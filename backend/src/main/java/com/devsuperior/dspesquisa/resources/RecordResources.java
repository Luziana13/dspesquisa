package com.devsuperior.dspesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.service.RecordService;

@RestController
@RequestMapping(value = "/records")
public class RecordResources {

	@Autowired
	public RecordService service;
	
	@PostMapping
	public ResponseEntity<RecordDTO> findAll(@RequestBody RecordInsertDTO dto){
		RecordDTO newDto = service.insert(dto);
		return ResponseEntity.ok().body(newDto);
	
	}
		
}
