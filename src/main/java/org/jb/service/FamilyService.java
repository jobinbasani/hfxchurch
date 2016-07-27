package org.jb.service;

import org.jb.data.model.Family;
import org.jb.data.model.Members;

import java.util.Collection;

public interface FamilyService {
	Family findById(Integer id);
	void addFamily(Family family);
	Collection<Members> getAllMembers();
}
