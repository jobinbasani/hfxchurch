package org.jb.rest;

import org.jb.vo.FamilyInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServices {

	@RequestMapping(value = "/names", produces = MediaType.APPLICATION_JSON_VALUE)
	public String printNames() {
		FamilyInfo family = new FamilyInfo();
		family.setAddress("38 Sienna Crt, Timberlea");
		return "jobin";
	}

	@RequestMapping(value = "/family", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public FamilyInfo getFamilyInfo() {
		FamilyInfo family = new FamilyInfo();
		family.setAddress("38 Sienna Crt, Timberlea");
		return family;
	}

}
