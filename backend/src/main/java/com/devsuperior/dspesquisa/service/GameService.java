package com.devsuperior.dspesquisa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;

@Service
public class GameService {

	@Autowired 
	public GameRepository repository;
	
	//EVITAR LOKING NO BANCO POIS O NIVEL DE BLOQUEIO É BAIXO JA QUE É UMA OPERAÇÃO SOMENTE DE BUSCAR
	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){
		List<Game> list = repository.findAll();
		//EXPRESSÃO LAMIDA, O STREAM PARA ACEITAR TAL EXPRESSÃO 
		//MAP VAI PERCORRER TODA A LISTA E TRANSFORMA OS OBJETOS
		//TRANSFORMANDO CADA OBJETO X, GAME, EM UM OBJETOS DO TIPO GAMEDTO EDEPOIS REOTRNANDO UMA LISTA
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}
	
}
