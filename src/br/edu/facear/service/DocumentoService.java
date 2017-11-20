package br.edu.facear.service;

import java.util.List;

import br.edu.facear.dao.DocumentoDAO;
import br.edu.facear.dao.TipoDocumentoDAO;
import br.edu.facear.model.Documento;
import br.edu.facear.model.TipoDocumento;

public class DocumentoService {
	
	DocumentoDAO empregadodao = new DocumentoDAO();
	TipoDocumentoDAO tipodao = new TipoDocumentoDAO();
	
	public void Inserir(Documento documento) {
		empregadodao.Inserir(documento);
	}
	public List<Documento> Pesquisar(int id) {
		return empregadodao.Pesquisarfoto(id);
	}
	public List<TipoDocumento> SearchTipodocumento(){
		return tipodao.PesquisarALL();
	}
}
