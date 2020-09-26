package com.vector.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.*; 
import com.vector.ecommerce.entity.State;

@CrossOrigin("http://localhost:4200")
public interface StateRepository extends JpaRepository<State, Integer>{
	List<State> findByCountryCode(@Param("code") String code);
}
