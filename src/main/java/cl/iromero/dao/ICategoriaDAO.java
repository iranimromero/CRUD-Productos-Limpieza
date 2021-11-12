package cl.iromero.dao;

import java.util.List;

import cl.iromero.model.Categoria;

public interface ICategoriaDAO {

	public List<Categoria> listarCategoria ();
	public Categoria buscarCategoria(int idCategoria);
}
