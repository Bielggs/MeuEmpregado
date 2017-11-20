package br.edu.facear.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.DocumentoEmpregado;
import br.edu.facear.model.TipoDocumento;

public class DocumentoEmpregadoDAO extends GenericDAO implements CrudeDAO<DocumentoEmpregado> {

	private String SQL_INSERT = "insert into empregadodocumento (iddocumento,idusuario,idtipo,dretorio) values (?,?,?,?);";
	private PreparedStatement ps = null;
	private ResultSet rs;
	List<TipoDocumento> tipo;
	private TipoDocumentoDAO tipodao;

	@Override
	public void Inserir(DocumentoEmpregado documento) {
		// TODO Auto-generated method stub
		try {
			openConnection();
			
			ps = connect.prepareStatement(SQL_INSERT);
			
			ps.setInt(1, documento.getIddocumento());
			
			ps.setInt(2, documento.getIdcliente());

			ps.setObject(3, documento.getTipodoc().getIdtipo());

			ps.setString(4, documento.getDiretorio());

			

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
	public void Excluir(DocumentoEmpregado t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Alterar(DocumentoEmpregado t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<?> PesquisarALL() {
		DocumentoEmpregado tipo = null;
		List<DocumentoEmpregado> lista = new ArrayList<>();
		try {
			openConnection();

			ps = connect.prepareStatement("SELECT * FROM tipodocumento;");
			rs = ps.executeQuery();

			while (rs.next()) {
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

	public List<DocumentoEmpregado> Pesquisarfoto(int id) {
		// TODO Auto-generated method stub
		DocumentoEmpregado c = null;
		TipoDocumento t = null;
		
		List<DocumentoEmpregado> documento = new ArrayList<>();
		
		try {
			openConnection();
			ps = connect.prepareStatement("SELECT * FROM empregadodocumento as a inner join tipodocumento as b "+ 
					"on a.idtipo = b.idtipodocumento where a.idusuario =" + id + ";" );
			
			
			rs = ps.executeQuery();
			
			
			

			while (rs.next()) {
				t = new TipoDocumento(rs.getInt("idtipodocumento"),  rs.getString("descricao"));
				c = new DocumentoEmpregado(rs.getInt("iddocumento"), rs.getInt("idusuario"), t, rs.getString("dretorio"));

				documento.add(c);
			}
			closeConnection();

		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found" + e);
		} catch (IOException e) {
			System.out.println("File not Found" + e);
		} catch (SQLException e) {
			System.out.println("Error on Connecting" + e);
		}
		return documento;
	}

}
