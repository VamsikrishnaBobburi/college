package com.college.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.Entity.College;

@Repository
public interface CollegeRepositroy extends JpaRepository<College, Integer>{

}
