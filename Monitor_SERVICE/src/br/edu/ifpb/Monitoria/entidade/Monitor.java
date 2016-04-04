package br.edu.ifpb.Monitoria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_monitor")
@NamedQuery(name = "Pessoa.getAll", query = "from Monitor")

public class Monitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_monitor")
	private int id;

	@Column(name = "nome_monitor")
	private String nome;
	
	@Column(name = "login_monitor")
	private String login;
	
	@Column(name = "senha_monitor")
	private String senha;
	
	@Column(name = "matricula_monitor")
	private String matricula;

	@Column(name = "disciplina_monitor")
	private String disciplina;
	
	@Column(name = "horario_monitor")
	private String horario;

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
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
