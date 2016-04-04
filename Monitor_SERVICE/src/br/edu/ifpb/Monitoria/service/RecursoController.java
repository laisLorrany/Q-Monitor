package br.edu.ifpb.Monitoria.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.ifpb.Monitoria.DAO.MonitorDAO;
import br.edu.ifpb.Monitoria.entidade.Monitor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/recurso")
public class RecursoController {
	

	 @POST
	 @Path("/login")
	 @Consumes("application/json")
	 @Produces("text/plain")
	 public boolean loginMonitor(String jsonLogin){
		 
		 Gson gson = new Gson();
		 Monitor monitor = (Monitor) gson.fromJson(jsonLogin, Monitor.class);
		 
		 Monitor monitorResult = MonitorDAO.getInstance().getById(monitor.getId());
		 		 
		 if (monitorResult != null){
			 return true;			 
		 }
		 return false;
	 }

}
