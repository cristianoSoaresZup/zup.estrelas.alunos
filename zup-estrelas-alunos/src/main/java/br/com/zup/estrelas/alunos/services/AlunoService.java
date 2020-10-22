package br.com.zup.estrelas.alunos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

	public Aluno insereAluno(Aluno aluno) {
		if (repository.existsById(aluno.getMatricula())) {
			return null;
		}
		return this.repository.save(aluno);
	}

	public List<Aluno> buscaAlunos() {
		return (List<Aluno>) repository.findAll();
	}

	public Aluno buscaAluno(Long matricula) {
		return repository.findById(matricula).get();
	}

	public boolean removeAluno(Long matricula) {
		if (repository.existsById(matricula)) {
			repository.deleteById(matricula);
			return true;
		}
		return false;
	}

	public Aluno alteraAluno(Aluno aluno) {
		if (repository.existsById(aluno.getMatricula())) {
			return repository.save(aluno);
		}
		return null;
	}
}
