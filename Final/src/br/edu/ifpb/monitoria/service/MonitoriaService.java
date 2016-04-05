package br.edu.ifpb.monitoria.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.ifpb.monitoria.entidade.Coordenador;
import br.edu.ifpb.monitoria.entidade.Monitor;


/**
 * Definition: Contains the services interfaces of QManager.
 * 
 * @author Rhavy Maia Guedes
 * 
 */
public interface MonitoriaService {

	/* Exemplos
		@GET
		@Path("/area/consultar/grandesareas/listar")
		@Produces("application/json")
		public List<GrandeArea> listarGrandesAreas();
	
	
		@POST
		@Path("/campus/consultar/locais")
		@Consumes("application/json")
		@Produces("application/json")
		public List<Campus> consultarLocais(Campus campus);
	*/
	@POST
	@Path("/monitor/disciplina/pesquisar")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Monitor> pesquisarMonitorDisciplina(Monitor monitor);
	

	@POST
	@Path("/monitor/cadastrar")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Monitor>cadastrarMonitor(Monitor monitor);

	@POST
	@Path("/coordenador/logar")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean logarCoordenador(Coordenador coordenador);	

	@POST
	@Path("/coordenador/disciplina/pesquisar")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Coordenador> pesquisarCoordenadorDisciplina(Coordenador coordenador);
	
}