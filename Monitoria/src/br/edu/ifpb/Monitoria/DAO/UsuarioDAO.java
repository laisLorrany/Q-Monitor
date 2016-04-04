package br.edu.ifpb.Monitoria.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.ifpb.Monitoria.Entidades.Cliente;
import br.edu.ifpb.Monitoria.Entidades.Usuario;

public class UsuarioDAO {

	GeneralDAO bd = new GeneralDAO();

	static int aux = 0;
	static ResultSet rs;

	public UsuarioDAO() {
	}

	// Método para consulta de usuários no BD
	public boolean consultaUser(Usuario user) {

		bd.abrirConexao();

		System.out.print("Consulta SQL" + user.getLogin() + " "
				+ user.getSenha());

		String sql = "SELECT u.nome " + "FROM usuario u " + "WHERE u.login='"
				+ user.getLogin() + "'" + "AND u.senha='" + user.getSenha()
				+ "'";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs == null) {
					aux = 0;
				} else {
					aux = 1;
				}
			}
			st.close();

		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar consulta");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe){
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		bd.fecharConexao();

		if (aux == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void insereUsuario(Cliente cliente) {

		try {

			bd.abrirConexao();
			Statement st = GeneralDAO.connection.createStatement();

			String sql = "INSERT INTO usuario (nome, disciplina, login, senha) "
					+ "VALUES ('"
					+ cliente.getNome()
					+ "','"
					+ cliente.getDisciplina()
					+ "','"					
					+ cliente.getLogin()
					+ "','"
					+ cliente.getSenha()+"')";

			st.executeUpdate(sql);
						
			st.close();
			bd.fecharConexao();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar inserção");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe){
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

	}
	
	public String procurarUsuario (String monitor){
		
		String horario="";
		
		bd.abrirConexao();


		String sql = "SELECT c.nome, c.horario " + "FROM CLIENTE c " + "WHERE c.disciplina='"
				+ monitor + "'";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs == null) {
					horario="Sem horário";
				} else {
					horario=rs.getString("horario");
				}
			}
			st.close();

		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar consulta");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe){
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		bd.fecharConexao();
		
		return horario;
		
	}
	
	public ArrayList<String> nomeMonitores(){
		
		ResultSet rs1;
		ArrayList<String> monitores = new ArrayList<String>();
		int i = 1;
		bd.abrirConexao();

		String sql = "SELECT u.nome FROM usuario u";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs1 = st.executeQuery(sql);
			while (rs1.next()) {
				System.out.println(rs1.getString(i) + " " + i);
				monitores.add(rs1.getString(i));
				i++;
			}
			st.close();

		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar consulta");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe){
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		bd.fecharConexao();
		
		return monitores;
	}
	
	public ArrayList<Cliente> quadroMonitores(){
		
		
		
		return null;
	}
}
