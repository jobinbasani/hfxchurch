package org.jb.service;

import org.jb.data.model.Family;

public interface FamilyService {
	Family findById(Integer id);
	void addFamily(Family family);
}
