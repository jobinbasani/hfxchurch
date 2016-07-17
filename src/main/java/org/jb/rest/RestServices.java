package org.jb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("service")
public class RestServices extends JaxRsActivator {
	
	@GET
	@Path("names")
	public String printNames(){
		return "jobin";
	}

}
