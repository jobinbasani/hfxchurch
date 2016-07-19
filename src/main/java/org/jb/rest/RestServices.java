package org.jb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jb.vo.FamilyInfo;

@Path("service")
@Produces(MediaType.APPLICATION_JSON)
public class RestServices  {
	
	@GET
	@Path("names")
	public String printNames(){
		FamilyInfo family = new FamilyInfo();
		family.setAddress("38 Sienna Crt, Timberlea");
		return "jobin";
	}
	
	@GET
	@Path("family")
	public FamilyInfo getFamilyInfo(){
		FamilyInfo family = new FamilyInfo();
		family.setAddress("38 Sienna Crt, Timberlea");
		return family;
	}

}
