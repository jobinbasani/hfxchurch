package org.jb.test.services;

import org.junit.Test;

public class FamilyServicesTest extends BaseTestCase{

	@Test
	public void testNames() throws Exception{
		System.out.println(getResponseBody("/names"));
	}
	
}
