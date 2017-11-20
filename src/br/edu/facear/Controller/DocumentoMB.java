package br.edu.facear.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import br.edu.facear.model.Documento;
import br.edu.facear.model.Empregado;
import br.edu.facear.model.TipoDocumento;
import br.edu.facear.service.DocumentoService;

@ManagedBean(name = "documentoEmpregadoMB")
@SessionScoped
public class DocumentoMB implements Serializable {

	private static final long serialVersionUID = -8542009263329649810L;

	private Documento documento;
	private DocumentoService service;
	private TipoDocumento tipodoc;
	private List<Documento> listadocuemto;
	private List<TipoDocumento> listTipodoc;
	private Empregado ep;

	private Part image;
	private String caminho;
	private String arraybytes64 = "Image/sem-imagem.jpg";
	private InputStream in;
	private int idtipo;

	public DocumentoMB() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession session = (HttpSession) request.getSession();
		ep = (Empregado) session.getAttribute("usuario");

		service = new DocumentoService();
		tipodoc = new TipoDocumento(0, "");
		documento = new Documento(0, ep.getId(), tipodoc, caminho);

		this.listTipodoc = service.PesquisarALL();
		this.listadocuemto = service.Pesquisar(ep.getId());
	}

	public void Validate(FacesContext context, UIComponent component, Object value) {
		Part file = (Part) value;

		if (file.getContentType() == "image/png" || file.getContentType() == "image/jpeg")
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Info",
					"Formato inválido plataforma somente suporta imagem."));
	}

	public void GeneretImageTable(String path) throws IOException {
		if (path == null) {

		} else {
			FileInputStream in = new FileInputStream(path);
			byte[] arraybytes = IOUtils.toByteArray(in);
			arraybytes64 = "data:image/png;base64," + new String(Base64.getEncoder().encode(arraybytes));
		}

	}

	public void GeneretImage() throws IOException {

		if (image == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Info", "Por favor selecione uma imagem."));
		} else if (image.getContentType().equals("image/png") || image.getContentType().equals("image/jpeg")) {
			Part i = image;
			InputStream in = i.getInputStream();
			InputStream in1 = i.getInputStream();

			caminho = "C:\\Users\\bielg\\Desktop\\imagens\\" + documento.getIddocumento() + documento.getIdcliente()
					+ documento.getTipodoc().getIdtipo() + image.getSubmittedFileName();

			Files.copy(in, new File(caminho).toPath());

			byte[] arraybytes = IOUtils.toByteArray(in1);

			// conveter o array de bytes em base64
			arraybytes64 = "data:image/png;base64," + new String(Base64.getEncoder().encode(arraybytes));

			in.close();
		} else {
			image.delete();
			Files.delete(new File(caminho).toPath());
			arraybytes64 = "";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Info",
					"Formato inválido plataforma somente suporta imagem."));
		}

	}

	public String SalvarAction() throws IOException {
		documento.setDiretorio(caminho);
		service.Inserir(documento);
		image.delete();
		caminho = "";
		arraybytes64 = "Image/sem-imagem.jpg";
		this.listadocuemto = service.Pesquisar(ep.getId());
		return "Documento.xhtml";
	}

	public void CancelAction() throws IOException {
		caminho = "";
		arraybytes64 = "Image/sem-imagem.jpg";
	}

	public void pesquisa() throws IOException {

		this.listadocuemto = service.Pesquisar(ep.getId());
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------
	public String getArraybytes64() {
		return arraybytes64;
	}

	public void setArraybytes64(String arraybytes64) {
		this.arraybytes64 = arraybytes64;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public DocumentoService getService() {
		return service;
	}

	public void setService(DocumentoService service) {
		this.service = service;
	}

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public TipoDocumento getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(TipoDocumento tipodoc) {
		this.tipodoc = tipodoc;
	}

	public List<TipoDocumento> getListTipodoc() {
		return listTipodoc;
	}

	public void setListTipodoc(List<TipoDocumento> listTipodoc) {
		this.listTipodoc = listTipodoc;
	}

	public List<Documento> getListadocuemto() {
		return listadocuemto;
	}

	public void setListadocuemto(List<Documento> listadocuemto) {
		this.listadocuemto = listadocuemto;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

}
