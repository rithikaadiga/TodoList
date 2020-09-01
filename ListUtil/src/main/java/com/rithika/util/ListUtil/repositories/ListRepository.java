package com.rithika.util.ListUtil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rithika.util.ListUtil.entities.ListEntities;

@Repository
public interface ListRepository extends CrudRepository<ListEntities, String>{

	List<ListEntities> findByUserName(String userName);
	
	void deleteByTaskId(Integer taskId);
	
	boolean existsByTaskId(Integer taskId);

}
