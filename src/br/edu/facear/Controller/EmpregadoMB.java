package br.edu.facear.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.facear.model.Empregado;
import br.edu.facear.service.EmpregadoService;

@ManagedBean(name = "empregadoMB")
@SessionScoped
public class EmpregadoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmpregadoService empregadoService;
	private Empregado empregado;
	
	public EmpregadoMB() {
		empregadoService = new EmpregadoService();
		empregado = new Empregado("", "");
	}

	public String Logar() {
		Empregado ep = empregadoService.Logar(empregado);
		
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.setAttribute("usuario", ep );
		return "Documento.xhtml";
	}
	
	public EmpregadoService getEmpregadoService() {
		return empregadoService;
	}

	public void setEmpregadoService(EmpregadoService empregadoService) {
		this.empregadoService = empregadoService;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	
	
}
