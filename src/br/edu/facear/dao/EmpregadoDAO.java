package br.edu.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.facear.model.Empregado;

public class EmpregadoDAO extends GenericDAO implements CrudeDAO<Empregado>{
	
	private String SQL_INSERT = "insert into empregadodocumento (idusuario,dretorio,iddocumento,idtipo) values (?,?,?, ?);";
	private PreparedStatement ps = null;
	private ResultSet rs;

	@Override
	public void Inserir(Empregado t) {
		
		try {
			openConnection();

			ps = connect.prepareStatement(SQL_INSERT);

			ps.setInt(1, t.getId());

			ps.setString(2, t.getNome());

			ps.setString(3, t.getEmail());


			ps.executeUpdate();

			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found" + e);
		} catch (IOException e) {
			System.out.println("File not Found" + e);
		} catch (SQLException e) {
			System.out.println("Error on Connecting" + e);
		}
	}

	@Override
	public void Excluir(Empregado t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Alterar(Empregado t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> PesquisarALL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Empregado Pesquisar(Empregado ep) {
		Empregado empregado = null;
		try {
			openConnection();

			ps = connect.prepareStatement("SELECT * FROM empregado;");
			rs = ps.executeQuery();
	
			
			while(rs.next()) {
				empregado = new Empregado(rs.getInt("id") , rs.getString("nome"), rs.getString("senha"));
				
					if(ep.getNome().equals(empregado.getNome()) && ep.getEmail().equals(empregado.getEmail())) {
						return empregado;
					}
				}
			closeConnection();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found" + e);
		} catch (IOException e) {
			System.out.println("File not Found" + e);
		} catch (SQLException e) {
			System.out.println("Error on Connecting" + e);
		}
		return null;
	}


}
