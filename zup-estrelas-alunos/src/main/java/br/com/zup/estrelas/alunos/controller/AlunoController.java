package br.com.zup.estrelas.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno insereAluno (@RequestBody Aluno aluno) {
		return this.alunoService.insereAluno(aluno);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Aluno> buscaAlunos() {
		return  alunoService.buscaAlunos();
	}
	
	@GetMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAluno (@PathVariable Long matricula) {
		return alunoService.buscaAluno(matricula);	
	}
	
	@DeleteMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public boolean removeAluno (@PathVariable Long matricula) {
		return this.alunoService.removeAluno(matricula);		
	}
	
	@PutMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public Aluno alteraAluno (@RequestBody Aluno aluno) {
		return this.alunoService.alteraAluno(aluno);		
	}

}
