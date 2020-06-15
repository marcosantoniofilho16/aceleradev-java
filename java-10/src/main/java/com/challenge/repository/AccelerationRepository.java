package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Acceleration;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
	
	@Query("select a from Acceleration a join a.candidates c "
			+ "where c.id.company.id = :companyId")
	List<Acceleration> findByIdCompanyId(Long companyId);

}
