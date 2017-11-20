package br.edu.facear.service;

import java.util.List;

import br.edu.facear.dao.DocumentoEmpregadoDAO;
import br.edu.facear.dao.TipoDocumentoDAO;
import br.edu.facear.model.DocumentoEmpregado;
import br.edu.facear.model.TipoDocumento;

public class DocumentoEmpregadoService {
	
	DocumentoEmpregadoDAO empregadodao = new DocumentoEmpregadoDAO();
	TipoDocumentoDAO tipodao = new TipoDocumentoDAO();
	
	public void Salvar(DocumentoEmpregado documento) {
		empregadodao.Inserir(documento);
	}
	public List<DocumentoEmpregado> Pesquisar(int id) {
		return empregadodao.Pesquisarfoto(id);
	}
	public List<TipoDocumento> SearchTipodocumento(){
		return tipodao.PesquisarALL();
	}
}
