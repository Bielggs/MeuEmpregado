package br.edu.facear.dao;

import java.util.List;

public interface CrudeDAO <T>{
	
	public void Inserir(T t);

	public void Excluir(T t);

	public void Alterar(T t);

	public List<?> PesquisarALL();

}
