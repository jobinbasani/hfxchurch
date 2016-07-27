package org.jb.service.impl;

import org.jb.data.model.Family;
import org.jb.data.model.Members;
import org.jb.data.repository.FamilyRepository;
import org.jb.data.repository.MembersRepository;
import org.jb.service.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Resource
	private FamilyRepository familyRepository;

	@Resource
	private MembersRepository membersRepository;
	
	@Override
	public Family findById(Integer id) {
		return familyRepository.findOne(id);
	}

	@Override
	public void addFamily(Family family) {
		familyRepository.save(family);
	}

	@Override
	public Collection<Members> getAllMembers() {
		return membersRepository.findAll();
	}

}
