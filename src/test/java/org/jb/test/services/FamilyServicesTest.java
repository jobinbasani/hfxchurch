package org.jb.test.services;

import org.jb.data.model.Family;
import org.jb.data.model.Members;
import org.jb.service.FamilyService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FamilyServicesTest extends BaseTestCase{

	@Test
	public void testNames() throws Exception{
		System.out.println(getResponseBody("/names"));
	}

	@Test
	public void testMemberService(){
		FamilyService familyService = getFamilyService();
		System.out.println("testing");
        for(Members members:familyService.getAllMembers()){
            System.out.println(members+"***"+members.getFamily());
        }
	}

    @Test
    public void testFamilyService(){
        Family family = getFamilyService().findById(1);
        System.out.println(family.getMembersList());
    }

    @Test
    public void addFamily(){
        Family family = new Family();
        family.setAddress("109 Greenpark Close");
        family.setNotes("from test case");
        Members members = new Members();
        members.setFirstName("JUnit");
        members.setFamily(family);
        List<Members> membersList = new ArrayList<>();
        membersList.add(members);
        family.setMembersList(membersList);
        getFamilyService().addFamily(family);
    }
	
}
