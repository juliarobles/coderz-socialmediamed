package modelo;

import java.util.ArrayList;
import java.util.List;

public class Propuesta {
	private int id;
	private String titulo;
	private String descripcion;
	private String imagen;
	private String fechainicial;
	private String fechafinal;
	private ZonaAccion zonaaccion;
	private TipoOferta tipooferta;
	private Ambito ambito;
	private Asignatura asignatura;
	private Proyecto proyecto;
	private ONG ong;
	private PDI investigador;
	private int aceptadogestor;
	private int aceptadopdi;
	
	public static List<Propuesta> getPropuestas() {
		List<Propuesta> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id FROM PROPUESTA")) {
			lista.add(new Propuesta((Integer)tupla[0]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getPropuestasSimple() { //pal gestor
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, titulo FROM PROPUESTA WHERE aceptadogestor = 0")) {
			lista.add(new Tupla(Integer.toString((Integer)tupla[0]), (String)tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	@Override
	public String toString() {
		return titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propuesta other = (Propuesta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public static List<Propuesta> getPropuestasFiltrado(ONG ong) { //para gestor
		List<Propuesta> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id FROM PROPUESTA WHERE ong = '" + ong.getEmail() +"' AND aceptadogestor = 0;")) {
			lista.add(new Propuesta((Integer)tupla[0]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Propuesta> getPropuestasFiltrado(String string) { //para gestor
		List<Propuesta> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id FROM PROPUESTA WHERE ong = '" + string +"' AND aceptadogestor = 0;")) {
			lista.add(new Propuesta((Integer)tupla[0]));
		}
		mibd.finalize();
		return lista;
	}
	
	public static List<Tupla> getPropuestasFiltradoSimple(String string) { //para gestor
		List<Tupla> lista = new ArrayList<>();
		BD mibd = new BD();
		for(Object[] tupla : mibd.Select("SELECT id, titulo FROM PROPUESTA WHERE ong = '" + string +"' AND aceptadogestor = 0;")) {
			lista.add(new Tupla(Integer.toString((Integer)tupla[0]), (String)tupla[1]));
		}
		mibd.finalize();
		return lista;
	}
	
	public Propuesta(int id) {
		BD mibd = new BD();
		Object[] tupla = mibd.Select("SELECT * FROM PROPUESTA WHERE id = " + id + ";").get(0);
		mibd.finalize();
		this.id = (Integer) tupla[0];
		this.titulo = (String) tupla[1];
		this.descripcion = (String) tupla[2];
		this.imagen = null;
		this.fechainicial = (String) tupla[4];
		this.fechafinal = (String) tupla[5];
		this.zonaaccion = ZonaAccion.valueOf((String)tupla[6]);
		this.tipooferta = TipoOferta.valueOf((String)tupla[7]);
		this.ambito = Ambito.valueOf((String)tupla[8]);
		this.asignatura = (tupla[9] == null)? null : new Asignatura((Integer)tupla[9]);
		this.proyecto = (tupla[10] == null)? null : new Proyecto((Integer)tupla[10]);
		this.ong = new ONG((String) tupla[11]);
		this.investigador = (tupla[12] == null)? null : new PDI((String)tupla[12]);
		this.aceptadogestor = (Integer) tupla[13];
		this.aceptadogestor = (Integer) tupla[14];
	}

	public Propuesta( String titulo, String descripcion, String fechainicial, String fechafinal, ZonaAccion zonaaccion, TipoOferta tipooferta, Ambito ambito, 
			Asignatura asignatura, Proyecto proyecto, ONG ong, PDI pdi, int aceptadogestor, int aceptadopdi) {
		
		String asig = (asignatura != null)? Integer.toString(asignatura.getId()) : "NULL";
		String proy = (proyecto != null)? Integer.toString(proyecto.getId()) : "NULL";
		String pdicargo = (pdi != null)? ("'" + pdi.getEmail() + "'") : "NULL";
		
		BD mibd = new BD();
		mibd.Insert("INSERT INTO PROPUESTA (titulo, descripcion, imagen, fechainicial, fechafinal, zonaaccion, tipooferta, ambito, asignatura, proyecto, ong, investigador, aceptadogestor, aceptadopdi) VALUES('" 
		+ titulo + "', '" + descripcion + "', NULL, '" + fechainicial 
				+ "', '" + fechafinal + "', '" + zonaaccion.toString() + "', '" + tipooferta.toString() + "', '" + ambito.toString() + "', " + asig + ", "  
										+ proy + ", '" + ong.getEmail() + "', " + pdicargo + ", " + aceptadogestor + ", " + aceptadopdi +");");
		this.id = (Integer) mibd.SelectEscalar("SELECT MAX(id) FROM PROPUESTA;");
		mibd.finalize();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = null;
		this.fechainicial = fechainicial;
		this.fechafinal = fechafinal;
		this.zonaaccion = zonaaccion;
		this.tipooferta = tipooferta;
		this.ambito = ambito;
		this.asignatura = asignatura;
		this.proyecto = proyecto;
		this.ong = ong;
		this.investigador = pdi;
		this.aceptadogestor = aceptadogestor;
		this.aceptadopdi = aceptadopdi;
	}
	
	public void eliminarPropuesta() {
		BD mibd = new BD();
		mibd.Delete("DELETE FROM PROPUESTA WHERE id = " + id + ";");
		mibd.finalize();
		this.id = -1;
		this.titulo = null;
		this.descripcion = null;
		this.fechainicial = null;
		this.fechafinal = null;
		this.zonaaccion = null;
		this.tipooferta = null;
		this.ambito = null;
		this.asignatura = null;
		this.proyecto = null;
		this.ong = null;
		this.investigador = null;
		this.aceptadogestor = -1;
		this.aceptadopdi = -1;
	}
	
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET titulo = '" + titulo + "' WHERE id = " + id +";");
		mibd.finalize();
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET descripcion = '" + descripcion + "' WHERE id = " + id +";");
		mibd.finalize();
		this.descripcion = descripcion;
	}
	
	public String getFechainicial() {
		return fechainicial;
	}
	
	public void setFechainicial(String fechainicial) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET fechainicial = '" + fechainicial + "' WHERE id = " + id +";");
		mibd.finalize();
		this.fechainicial = fechainicial;
	}
	
	public String getFechafinal() {
		return fechafinal;
	}
	
	public void setFechafinal(String fechafinal) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET fechafinal = '" + fechafinal + "' WHERE id = " + id +";");
		mibd.finalize();
		this.fechafinal = fechafinal;
	}
	
	public ONG getOng() {
		return ong;
	}
	
	public void setOng(ONG ong) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET ong = '" + ong.getEmail() + "' WHERE id = " + id +";");
		mibd.finalize();
		this.ong = ong;
	}

	public ZonaAccion getZonaaccion() {
		return zonaaccion;
	}

	public void setZonaaccion(ZonaAccion zonaaccion) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET zonaaccion = '" + zonaaccion.toString() + "' WHERE id = " + id +";");
		mibd.finalize();
		this.zonaaccion = zonaaccion;
	}

	public TipoOferta getTipooferta() {
		return tipooferta;
	}

	public void setTipooferta(TipoOferta tipooferta) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET tipooferta = '" + tipooferta.toString() + "' WHERE id = " + id +";");
		mibd.finalize();
		this.tipooferta = tipooferta;
	}

	public Ambito getAmbito() {
		return ambito;
	}

	public void setAmbito(Ambito ambito) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET ambito = '" + ambito.toString() + "' WHERE id = " + id +";");
		mibd.finalize();
		this.ambito = ambito;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		BD mibd = new BD();
		if(asignatura == null) {
			mibd.Update("UPDATE PROPUESTA SET asignatura = NULL WHERE id = " + id +";");
		} else {
			mibd.Update("UPDATE PROPUESTA SET asignatura = " + asignatura.getId() + " WHERE id = " + id +";");
		}
		mibd.finalize();
		this.asignatura = asignatura;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		BD mibd = new BD();
		if(proyecto == null) {
			mibd.Update("UPDATE PROPUESTA SET proyecto = NULL WHERE id = " + id +";");
		} else {
			mibd.Update("UPDATE PROPUESTA SET proyecto = " + proyecto.getId() + " WHERE id = " + id +";");
		}
		mibd.finalize();
		this.proyecto = proyecto;
	}

	public PDI getInvestigador() {
		return investigador;
	}

	public void setInvestigador(PDI investigador) {
		BD mibd = new BD();
		if(investigador == null) {
			mibd.Update("UPDATE PROPUESTA SET investigador = NULL WHERE id = " + id +";");
		} else {
			mibd.Update("UPDATE PROPUESTA SET investigador = '" + investigador.getEmail() + "' WHERE id = " + id +";");
		}
		mibd.finalize();
		this.investigador = investigador;
	}

	public int getAceptadogestor() {
		return aceptadogestor;
	}

	public void setAceptadogestor(int aceptadogestor) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET aceptadogestor = " + aceptadogestor + " WHERE id = " + id +";");
		mibd.finalize();
		this.aceptadogestor = aceptadogestor;
	}

	public int getAceptadopdi() {
		return aceptadopdi;
	}

	public void setAceptadopdi(int aceptadopdi) {
		BD mibd = new BD();
		mibd.Update("UPDATE PROPUESTA SET aceptadopdi = " + aceptadopdi + " WHERE id = " + id +";");
		mibd.finalize();
		this.aceptadopdi = aceptadopdi;
	}
}

