package com.edu.eci.arep.secureapp.repository;

import com.edu.eci.arep.secureapp.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> { }

