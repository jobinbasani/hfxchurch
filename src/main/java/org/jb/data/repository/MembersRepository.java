package org.jb.data.repository;

import org.jb.data.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jobinbasani on 7/26/16.
 */
public interface MembersRepository extends JpaRepository<Members, Integer> {

}
