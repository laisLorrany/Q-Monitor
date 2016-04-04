package br.edu.ifpb.Monitoria.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

@Path("/quadro")
public class RecursoQuadro {

	 @POST
	 @Produces("application/json")
	 public String quadroMonitores(String u){
		 
		 ArrayList <String> monitores = new ArrayList<String>();
			ArrayList <String> disciplinas = new ArrayList<String>();		
			ArrayList<ArrayList> quadro = new ArrayList<ArrayList>();
			
			monitores.add("Laís");
			monitores.add("Myllena");
			
			
			quadro.add(monitores);
			quadro.add(disciplinas);
			
			Gson gson = new Gson();
			String quadroMonitores = gson.toJson(quadro);
					
			return quadroMonitores;
	 }

}
