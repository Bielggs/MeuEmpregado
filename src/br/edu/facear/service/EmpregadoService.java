package br.edu.facear.service;

import br.edu.facear.dao.EmpregadoDAO;
import br.edu.facear.model.Empregado;

public class EmpregadoService {
	
	EmpregadoDAO empregadodao = new EmpregadoDAO();

	public Empregado Logar(Empregado empregado) {
		return empregadodao.Pesquisar(empregado);
	}

}
