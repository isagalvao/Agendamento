package model;

public class JavaBeans {

	private String idagendamento;
	private String idmorador;
	private String data;
	private String hora;
	
	public JavaBeans() {
		super();	
	}
	
	public JavaBeans(String idagendamento, String idmorador, String data, String hora) {
		super();
		this.idagendamento = idagendamento;
		this.idmorador = idmorador;
		this.data = data;
		this.hora = hora;
	}

	public String getIdagendamento() {
		return idagendamento;
	}
	public void setIdagendamento(String idagendamento) {
		this.idagendamento = idagendamento;
	}
	public String getIdmorador() {
		return idmorador;
	}
	public void setIdmorador(String idmorador) {
		this.idmorador = idmorador;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
