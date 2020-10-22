package br.com.zup.estrelas.alunos.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno {

	@Id
	private long matricula;

	@Column(nullable = false)
	private String nome;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNascimento;
	
	@Column(name = "nome_da_mae")
	private String nomeDaMae;

	public Aluno() {

	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getNomeDaMae () {
		return nomeDaMae;
	}
	
	public void setNomeDaMae (String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

}
