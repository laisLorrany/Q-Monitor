package br.edu.ifpb.Monitoria.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import br.edu.ifpb.Monitoria.DAO.MonitorDAO;
import br.edu.ifpb.Monitoria.entidade.Erro;
import br.edu.ifpb.Monitoria.entidade.Monitor;

@Path("monitor")
public class MonitorController {

	private static Logger logger = LogManager.getLogger(MonitorController.class);

	@POST
	@Path("/disciplina/pesquisar")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Monitor> pesquisarMonitorDisciplina(Monitor monitor) {

		String disciplina = monitor.getDisciplina().trim().toUpperCase();
		
		logger.info("Listar Recurso: " + disciplina);		

		List<Monitor> monitores = MonitorDAO.getInstance().getByName(disciplina);
		
		logger.info("Participantes: " + monitores.size() + "[" + monitores + "]");

		return monitores;
	}

	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrarMonitor(Monitor monitor) {
		
		logger.info("/register: " + monitor);		
		ResponseBuilder builder;
		
		try {
			
			MonitorDAO.getInstance().insert(monitor);
			builder = Response.status(Response.Status.CREATED);			
			
		} catch (HibernateException hexp) {	
			
			Erro erro = new Erro(1, "Problema na inserção do participante");
			builder = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(erro);
		}

		return builder.build();
	}
}