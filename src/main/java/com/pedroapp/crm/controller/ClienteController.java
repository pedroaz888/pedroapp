package com.pedroapp.crm.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedroapp.crm.model.Cliente;
import com.pedroapp.crm.model.DadosBasicosCliente;
import com.pedroapp.crm.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	@GetMapping
	@Cacheable(value = "listaClientes")
	public Page<Cliente> listar(Principal princiapal){
		
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0,5,sort);
		
			
		return clienteRepository.findAll(paginacao);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	@CacheEvict(value = "listaClientes", allEntries=true )
	public Cliente adicionar (@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?>remover (@PathVariable Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if( optional.isPresent()){
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
			return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DadosBasicosCliente> detalhar (@PathVariable Long id) {
		Optional<Cliente> detalhe = clienteRepository.findById(id);
		if(detalhe.isPresent()){
			return ResponseEntity.ok(new DadosBasicosCliente(detalhe.get()));
		}
		
			return ResponseEntity.notFound().build();
			
	}

}
