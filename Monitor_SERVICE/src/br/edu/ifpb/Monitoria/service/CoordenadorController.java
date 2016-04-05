package br.edu.ifpb.Monitoria.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.edu.ifpb.Monitoria.DAO.CoordenadorDAO;
import br.edu.ifpb.Monitoria.entidade.Coordenador;

@Path("/coordenador")
public class CoordenadorController {
	

	 @POST
	 @Path("/login")
	 @Consumes("application/json")
	 @Produces("text/plain")
	 public boolean loginCoordenador(Coordenador coordenador){
		 
		
		 Coordenador coordenadorResult = CoordenadorDAO.getByLogin(coordenador);
		 		 
		 if (coordenadorResult != null){
			 return true;			 
		 }
		 return false;
	 }

}
