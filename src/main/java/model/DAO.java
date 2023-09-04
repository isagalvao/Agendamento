package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Modulo de conexão **/
// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbacademia?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";

// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CREATE **/
	public void inserirAgendamento(JavaBeans agendamento) {
		String create = "insert into agendamento(data, hora) values (?, ?)";
		try {
			// abrindo conexão
			Connection con = conectar();
			// preparando a query
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conteudo das variáveis
			pst.setString(1, agendamento.getData());
			pst.setString(2, agendamento.getHora());
			// Executando a query
			pst.executeUpdate();
			// Encerrando conexão com a DB
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** READ **/
	public ArrayList<JavaBeans> listarAgendamentos() {
		// objeto para acessa javabeans
		ArrayList<JavaBeans> agendamentos = new ArrayList<>();
		String read = "select * from agendamento order by data asc";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idagendamento = rs.getString(1);
				String idmorador = rs.getString(2);
				String data = rs.getString(3);
				String hora = rs.getString(4);
				// inserindo no arraylist
				agendamentos.add(new JavaBeans(idagendamento, idmorador, data, hora));
			}
			con.close();
			return agendamentos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	/** DELETE **/
	public void deletarAgendamento(JavaBeans agendamento) {
		String delete = "delete from agendamento where idagendamento=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, agendamento.getIdagendamento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	// conexão teste
	// public void testeConexao() {
	// try {
	// Connection con =conectar();
	// System.out.println(con);
	// con.close();
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	// }
}
