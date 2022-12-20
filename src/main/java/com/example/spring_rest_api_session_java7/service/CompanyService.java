package com.example.spring_rest_api_session_java7.service;


import com.example.spring_rest_api_session_java7.dto.company.CompanyRequest;
import com.example.spring_rest_api_session_java7.dto.company.CompanyResponse;

import java.util.List;

public interface CompanyService {
    List<CompanyResponse> getAllCompanies();

    CompanyResponse addCompany(CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);

    CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest);

    CompanyResponse deleteCompany(Long companyId);
}
