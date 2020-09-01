package com.rithika.util.ListUtil.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rithika.util.ListUtil.entities.UserEntities;

@Repository
public interface UserRepository extends CrudRepository<UserEntities, String>{


}
