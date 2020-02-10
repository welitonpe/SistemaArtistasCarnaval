package br.unit.controller;

import java.util.ArrayList;

import br.unit.dao.ArtistaDao;
import br.unit.model.Artista;


public class ArtistaController {
	ArtistaDao artistasDao;

	//CONSTRUTOR
	public ArtistaController() {
		artistasDao = new ArtistaDao();
	}

	//CONSTRUTOR EM SOBRECARGA
	public void inserir (String nome, String nascimento, String cidade, String vaiTocar) throws Exception {
		Artista artista = new Artista();
		artista.setNome(nome);
		artista.setAnoNascimento(nascimento);
		artista.setCidade(cidade);
		artista.setVaiTocar(vaiTocar);

		if(artistasDao.existe(nome)) {
			throw new Exception("Artista ja cadastrado!");
		} else { 
			artistasDao.inserir(artista);
		}
	}
	
	//CONSULTAR
	public Artista consultar(String nome) throws Exception{
		return artistasDao.consultar(nome);
	}
	
	//EXISTE
	public boolean existe(String nome) throws Exception{
		if (artistasDao.existe(nome)){
			return true;
		} else {
			throw new Exception("Artista não cadastrado!");
		}
	}
	
	//ALTERAR SE EXISTIR
	 public void alterar(String nome, String nascimento, String cidade, String vaiTocar) throws Exception {
		 Artista artista = new Artista();
		 artista.setNome(nome);
		 artista.setAnoNascimento(nascimento);
		 artista.setCidade(cidade);
		 artista.setVaiTocar(vaiTocar);
		 
		 if(existe(nome)) {
			 artistasDao.alterar(nome, artista);
		 } else {
			throw new Exception("Alteração não pode ser completada, artista não cadastrado!");
		 }
	 }
	 public void remover(String nome) throws Exception{
		 if(existe(nome)) {
			 artistasDao.remover(nome);
		 }
	 }
	 
	 //RETORNA TODOS
	 public ArrayList<Artista> retornarTodos(){
		 return artistasDao.retornarTodos();
	 }
	 
	 //INSERIR TODOS
	 public void inserirTodos(ArrayList<Artista> artistaList) {
		 artistasDao.inserirTodos(artistaList);
	 }
	
	
}