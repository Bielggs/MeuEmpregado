package br.edu.facear.model;

public class DocumentoEmpregado {
	
	private int iddocumento;
	private int idcliente;
	private TipoDocumento tipodoc;
	private String diretorio;

	public DocumentoEmpregado() {
		
	}
	
	public DocumentoEmpregado(int iddocumento, int idcliente, TipoDocumento tipodoc, String diretorio) {
		this.iddocumento = iddocumento;
		this.idcliente = idcliente;
		this.tipodoc = tipodoc;
		this.diretorio = diretorio;
	}

	public int getIddocumento() {
		return iddocumento;
	}

	public void setIddocumento(int iddocumento) {
		this.iddocumento = iddocumento;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}


	public TipoDocumento getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(TipoDocumento tipodoc) {
		this.tipodoc = tipodoc;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

}
