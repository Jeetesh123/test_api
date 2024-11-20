package com.test.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.TestEntity;

@RepositoryDefinition(domainClass = TestEntity.class, idClass = Integer.class)
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
	
	@Query("SELECT e FROM TestEntity e WHERE e.region = :region")
	List<TestEntity> findFAbyRegion(@Param("region") String region);
	
	@Query("SELECT e FROM TestEntity e WHERE e.id = :id")
	List<TestEntity> findFAbyID(@Param("id") Integer id);
	
}
