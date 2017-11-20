package br.edu.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.facear.model.TipoDocumento;

public class TipoDocumentoDAO extends GenericDAO implements CrudeDAO<TipoDocumento>{
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void Inserir(TipoDocumento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Excluir(TipoDocumento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Alterar(TipoDocumento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoDocumento> PesquisarALL() {
		// TODO Auto-generated method stub
		TipoDocumento tipo= null;
		List<TipoDocumento> lista = new ArrayList<TipoDocumento>();
		try {
			openConnection();

			ps = connect.prepareStatement("SELECT * FROM tipodocumento;");
			rs = ps.executeQuery();
	
			
			while(rs.next()) {
				tipo = new TipoDocumento(rs.getInt("idtipodocumento") , rs.getString("descricao"));
				lista.add(tipo);
				}
			closeConnection();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found" + e);
		} catch (IOException e) {
			System.out.println("File not Found" + e);
		} catch (SQLException e) {
			System.out.println("Error on Connecting" + e);
		}
		return lista;
	}

}
