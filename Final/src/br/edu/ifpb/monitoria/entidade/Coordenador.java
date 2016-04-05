package br.edu.ifpb.monitoria.entidade;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@ViewScoped
@ManagedBean
@Entity
@Table(name = "tb_coordenador")
@NamedQuery(name = "Pessoa.getAll", query = "from Coordenador")
public class Coordenador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coordenador")
	private int id;

	@Column(name = "nome_coordenador")
	private String nome;

	@Column(name = "login_coordenador")
	private String login;

	@Column(name = "senha_coordenador")
	private String senha;

	@Column(name = "matricula_coordenador")
	private String matricula;

	@Column(name = "disciplina_coordenador")
	private String disciplina;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDisciplina() {
		return matricula;
	}

	public void setDisciplina(String matricula) {
		this.matricula = matricula;
	}



}
