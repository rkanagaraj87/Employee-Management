
package com.emp.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp.main.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query("Select c.companyId from Company c where c.companyName =?1")
	Optional<Integer> findByName(String name);
}
