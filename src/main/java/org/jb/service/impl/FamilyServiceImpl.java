package org.jb.service.impl;

import javax.annotation.Resource;

import org.jb.data.model.Family;
import org.jb.data.repository.FamilyRepository;
import org.jb.service.FamilyService;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Resource
	private FamilyRepository familyRepository;
	
	@Override
	public Family findById(Integer id) {
		return familyRepository.findOne(id);
	}

	@Override
	public void addFamily(Family family) {
		familyRepository.save(family);
	}

}
