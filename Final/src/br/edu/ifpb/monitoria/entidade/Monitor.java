package br.edu.ifpb.monitoria.entidade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.edu.ifpb.monitoria.util.HttpService;
import br.edu.ifpb.monitoria.util.Response;

@ViewScoped
@ManagedBean
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
/*
	public void cadastra() {
		Gson gson = new Gson();
		Response response = null;
		String stringJSON = gson.toJson(this);
		try {
			response = HttpService.sendJSONPostResquest("register", stringJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public List<Monitor> encontra (){
		
		Gson gson = new Gson();
		Response response = null;
		String stringJSON = gson.toJson(this);
		try {
			response = HttpService.sendJSONPostResquest("get-byname", stringJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Monitor> monitores = gson.fromJson(response.getContentValue(),
				new TypeToken<ArrayList<Monitor>>() {
				}.getType());
		
		return monitores;
	}*/
}
