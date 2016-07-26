package org.jb.service.rest;

import org.jb.data.model.Family;
import org.jb.service.FamilyService;
import org.jb.vo.FamilyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RestServices {

    @Autowired
    private FamilyService familyService;

    @RequestMapping(value = "/names", produces = APPLICATION_JSON_VALUE)
    public String printNames() {
        System.out.println(familyService.findById(1));
        Family family = new Family();
        family.setNotes("from rest");
        familyService.addFamily(family);
        return "jobin";
    }

    @RequestMapping(value = "/family", produces = APPLICATION_JSON_VALUE, method = GET)
    public FamilyInfo getFamilyInfo() {
        FamilyInfo family = new FamilyInfo();
        family.setAddress("38 Sienna Crt, Timberlea");
        return family;
    }

}
