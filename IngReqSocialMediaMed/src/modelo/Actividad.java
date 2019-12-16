package modelo;

import java.util.ArrayList;
import java.util.List;

import utilidades.DiaSemana;

public class Actividad {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String imagen;
	private String fechainicio;
	private String fechafinal;
	private ZonaAccion zonaaccion;
	private TipoOferta tipooferta;
	private Asignatura asignatura;
	private Proyecto proyecto;
	private ONG ong;
	private PDI investigador;
	private Ambito ambito;
	
	
	public static List<Tupla> getMatch(Usuario u){
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		String[] fecha;
		String f;
		
		if(u != null) {
			List<Object[]> tupla = mibd.Select("SELECT id, titulo, fechainicio FROM ACTIVIDADES WHERE tipooferta = '" + u.tipoOferta + "' and zonaaccion = '" + u.zonaAccion + "' LIMIT 15;");
			if(u.disponibilidad.equals(Disponibilidad.Siempre)){
				for(Object[] t : tupla) {
					lista.add(new Tupla(Integer.toString((Integer) t[0]), (String) t[1]));
				}
			} else {
				List<Object[]> noEnLista = new ArrayList<>();
				for(Object[] t : tupla) {
					fecha = ((String) t[2]).split("/");
					f = DiaSemana.diaSemana(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]));
					if(u.disponibilidad.equals(Disponibilidad.FindeSemana) && (f.equals("S") || f.equals("D"))) {
						lista.add(new Tupla(Integer.toString((Integer) t[0]), (String) t[1]));
					} else if (u.disponibilidad.equals(Disponibilidad.EntreSemana) && !f.equals("S") && !f.equals("D")) {
						lista.add(new Tupla(Integer.toString((Integer) t[0]), (String) t[1]));
					} else {
						noEnLista.add(t);
					}
				}
				if(lista.size() < 15 && !noEnLista.isEmpty()) {
					Object[] t;
					for(int i = 0; i < noEnLista.size() && lista.size() < 15; i++) {
						t = noEnLista.get(i);
						lista.add(new Tupla(Integer.toString((Integer) t[0]), (String) t[1]));
					}
				}
			}
			if(lista.size() < 15) {
				for(Object[] t : mibd.Select("SELECT id, titulo FROM ACTIVIDADES WHERE tipooferta = '" + u.tipoOferta.toString() + "' AND zonaaccion <> '" + u.zonaAccion.toString() + "' LIMIT " + (15 - lista.size())+ ";")) {
					lista.add(new Tupla(Integer.toString((Integer) t[0]), (String) t[1]));
				}
			}
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getUltimasAniadidas() {
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, titulo FROM ACTIVIDADES ORDER BY id DESC LIMIT 15;")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getMasSolicitadas() {
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT a.id, a.titulo, count(s.participante) FROM ACTIVIDADES a, SOLICITUDES s WHERE a.id = s.actividad GROUP BY a.id ORDER BY count(s.participante) DESC LIMIT 15;")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	
	public boolean esVoluntariado() {
		return asignatura == null && investigador == null;
	}
	
	public List<Tupla> getParticipantes() {
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT u.email, u.nombre, u.apellido1, u.apellido2 FROM PARTICIPAR p, PARTICIPANTES u WHERE u.email = p.usuario AND p.actividad = " + this.id + ";")) {
			lista.add(new Tupla((String) tupla[0], (String) tupla[1] + " " + (String) tupla[2] + " " + (String) tupla[3]));
		}
		mibd.finalize();
		return lista;
	}
	
	public void borrarParticipantes(List<Tupla> eliminados) {
		BD mibd = new BD();
		for(Tupla t : eliminados) {
			mibd.Delete("DELETE FROM PARTICIPAR WHERE usuario = '" + t.elemento1 + "' AND actividad = " + this.id + ";");
		}
		mibd.finalize();
	}
	
	public void aniadirParticipante(String email) {
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PARTICIPAR VALUES('" + email + "', " + this.id + ");");
		mibd.finalize();
	}
	
	public static List<Tupla> getActividadesDisponiblesSimple(){
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, titulo FROM ACTIVIDADES WHERE proyecto IS NULL")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getActividadesSimple(){
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, titulo FROM ACTIVIDADES")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getActividadesSimpleConAccesoPDI(String emailpdi) {
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT DISTINCT a.id, a.titulo FROM ACTIVIDADES a LEFT OUTER JOIN PROYECTO p ON a.proyecto = p.id LEFT OUTER JOIN ASIGNATURAS s ON a.asignatura = s.id WHERE a.investigador = '" + 
				emailpdi + "' OR p.pdi = '" + emailpdi + "' OR s.PDICargo = '" + emailpdi + "';")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getActividadesSimpleConAccesoONG(String emailong) {
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, titulo FROM ACTIVIDADES WHERE ong = '" + emailong + "';")) {
			lista.add(new Tupla(Integer.toString((Integer) tupla[0]), (String) tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public Actividad(int id) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM ACTIVIDADES WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer)tupla[0];
		this.titulo = (String)tupla[1];
		this.descripcion = (String)tupla[2];
		this.imagen = null; //POR AHORA NULL HASTA QUE MIREMOS LO DE LAS IMAGENES
		this.fechainicio = (String)tupla[4];
		this.fechafinal = (String)tupla[5];
		this.zonaaccion = ZonaAccion.valueOf((String)tupla[6]);
		this.tipooferta = TipoOferta.valueOf((String)tupla[7]);
		//this.asignatura = new Asignatura((Integer)tupla[8]);
		this.asignatura = (tupla[8] == null)? null : new Asignatura((Integer)tupla[8]);
		//this.proyecto = new Proyecto((Integer)tupla[9]);
		this.proyecto = (tupla[9] == null)? null : new Proyecto((Integer)tupla[9]);
		this.ong = new ONG((String)tupla[10]);
		this.investigador = (tupla[11] == null)? null : new PDI((String)tupla[11]);
		this.ambito = Ambito.valueOf((String)tupla[12]);
	}

	public Actividad(String titulo, String descripcion, String imagen, String fechainicio, String fechafinal,
			ZonaAccion zonaaccion, TipoOferta tipooferta, Asignatura asignatura, Proyecto proyecto, ONG ong, PDI pdi, Ambito ambito) {
		
		String asig = (asignatura != null)? Integer.toString(asignatura.getId()) : "NULL";
		String proy = (proyecto != null)? Integer.toString(proyecto.getId()) : "NULL";
		String pdicargo = (pdi != null)? pdi.getEmail() : "NULL";
	
		BD mibd = new BD();
		mibd.Insert("INSERT INTO ACTIVIDADES (titulo, descripcion, imagen, fechainicio, fechafinal, zonaaccion, tipooferta, asignatura, proyecto, ong, investigador, ambito) "
				+ "VALUES('" + titulo + "', '" + descripcion + "', NULL, '" + fechainicio + "', '" 
				+ fechafinal + "', '" + zonaaccion.toString() + "', '" + tipooferta.toString() + "', " + asig + ", " 
				+ proy + ", '" + ong.getEmail() + "', " + pdicargo + ", '" + ambito.toString() + "');");
		
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM ACTIVIDADES;");
		mibd.finalize();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.fechainicio = fechainicio;
		this.fechafinal = fechafinal;
		this.zonaaccion = zonaaccion;
		this.tipooferta = tipooferta;
		this.asignatura = asignatura;
		this.proyecto = proyecto;
		this.ong = ong;
		this.investigador = pdi;
		this.ambito = ambito;
	}
	
	public void borrarActividad() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM SEGUIMIENTO WHERE actividad = " + id + ";");
		mibd.Delete("DELETE FROM ACTIVDIDADES WHERE id = " + id + ";");
		mibd.finalize();
		
		this.id = -1;
		this.titulo = null;
		this.descripcion = null;
		this.imagen = null;
		this.fechainicio = null;
		this.fechafinal = null;
		this.zonaaccion = null;
		this.tipooferta = null;
		this.asignatura = null;
		this.proyecto = null;
		this.ong = null;
		this.investigador = null;
		this.ambito = null;
	}
	
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET titulo = '" + titulo + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET descripcion = '" + descripcion + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.descripcion = descripcion;
	}
	
	public String getImagen() {
		return imagen;
	}
	/*HAY QUEMIRAR
	public void setImagen(String imagen) {
		BD mibd = new BD();
		mibd.Update("");
		mibd.finalize();
		this.imagen = imagen;
	}
	*/
	public String getFechainicio() {
		return fechainicio;
	}
	
	public void setFechainicio(String fechainicio) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET fechainicio = '" + fechainicio + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.fechainicio = fechainicio;
	}
	
	public String getFechafinal() {
		return fechafinal;
	}
	
	public void setFechafinal(String fechafinal) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET fechafinal = '" + fechafinal + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.fechafinal = fechafinal;
	}
	
	public ZonaAccion getZonaaccion() {
		return zonaaccion;
	}
	
	public void setZonaaccion(ZonaAccion zonaaccion) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET zonaaccion = '" + zonaaccion.toString() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.zonaaccion = zonaaccion;
	}
	
	public TipoOferta getTipooferta() {
		return tipooferta;
	}
	
	public void setTipooferta(TipoOferta tipooferta) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET tipooferta = '" + tipooferta.toString() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.tipooferta = tipooferta;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	public void setAsignatura(Asignatura asignatura) {
		BD mibd = new BD();
		if(asignatura == null) {
			mibd.Update("UPDATE ACTIVIDADES SET asignatura = NULL WHERE id = " + this.id + ";");
			mibd.finalize();
			this.asignatura = null;
		} else {
			mibd.Update("UPDATE ACTIVIDADES SET asignatura = " + asignatura.getId() + " WHERE id = " + this.id + ";");
			mibd.finalize();
			this.asignatura = asignatura;
		}
		
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	
	public void setProyecto(Proyecto proyecto) {
		BD mibd = new BD();
		if(proyecto == null) {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = NULL WHERE id = " + this.id + ";");
			mibd.finalize();
			this.proyecto = null;
		} else {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = " + proyecto.getId() + " WHERE id = " + this.id + ";");
			mibd.finalize();
			this.proyecto = proyecto;
		}
		
	}
	
	public static void setProyectoSimple(Proyecto proyecto, int id) {
		BD mibd = new BD();
		if(proyecto == null) {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = NULL WHERE id = " + id + ";");
		} else {
			mibd.Update("UPDATE ACTIVIDADES SET proyecto = " + proyecto.getId() + " WHERE id = " + id + ";");
		}
		mibd.finalize();
	}
	
	public ONG getOng() {
		return ong;
	}
	
	public void setOng(ONG ong) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET ong = '" + ong.getEmail() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.ong = ong;
	}

	public PDI getInvestigador() {
		return investigador;
	}

	public void setInvestigador(PDI investigador) {
		BD mibd = new BD();
		if(investigador == null) {
			mibd.Update("UPDATE ACTIVIDADES SET investigador = NULL WHERE id = " + this.id + ";");
			mibd.finalize();
			this.investigador = null;
		} else {
			mibd.Update("UPDATE ACTIVIDADES SET investigador = '" + investigador.getEmail() + "' WHERE id = " + this.id + ";");
			mibd.finalize();
			this.investigador = investigador;
		}
		
	}

	public Ambito getAmbito() {
		return ambito;
	}

	public void setAmbito(Ambito ambito) {
		BD mibd = new BD();
		mibd.Update("UPDATE ACTIVIDADES SET ambito = '" + ambito.toString() + "' WHERE id = " + this.id + ";");
		mibd.finalize();
		this.ambito = ambito;
	}

	

	
	
}
