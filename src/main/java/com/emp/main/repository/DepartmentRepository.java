
package com.emp.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp.main.entity.Department;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("Select d.departmentId from Department d where d.departmentName =?1")
	Optional<Integer> findByName(String name);
}
