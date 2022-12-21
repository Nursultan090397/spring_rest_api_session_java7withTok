package com.example.spring_rest_api_session_java7.repository;


import com.example.spring_rest_api_session_java7.entities.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select p from Company p where upper(p.companyName) like concat('%', :pagination, '%') or upper(p.locatedCountry) like concat('%', :pagination, '%') ")
    List<Company> searchPagination(@Param("pagination") String pagination, Pageable pageable);
}
