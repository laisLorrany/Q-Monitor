package br.edu.ifpb.monitoria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifpb.monitoria.entidade.Coordenador;
import br.edu.ifpb.monitoria.service.MonitoriaService;
import br.edu.ifpb.monitoria.service.ProviderServiceFactory;

@ManagedBean (name = "coordenadorBean")
@RequestScoped
public class CoordenadorBean {
	
	private Coordenador coordenador;
	private List<Coordenador> coordenadores;
	boolean logado;
	
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public List<Coordenador> getCoordenadores() {
		return coordenadores;
	}

	public void setCoordenadores(List<Coordenador> coordenadores) {
		this.coordenadores = coordenadores;
	}

	public CoordenadorBean() {
		this.coordenador = new Coordenador();
		this.coordenadores = new ArrayList<Coordenador>();
	}
	
	public String logar() {
		
		MonitoriaService service = ProviderServiceFactory
				.createServiceClient(MonitoriaService.class);
		
		logado = service.logarCoordenador(coordenador);

		return null;
	}
	
}
