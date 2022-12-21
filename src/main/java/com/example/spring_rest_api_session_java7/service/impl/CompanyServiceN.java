package com.example.spring_rest_api_session_java7.service.impl;

import com.example.spring_rest_api_session_java7.dto.company.CompanyResponse;
import com.example.spring_rest_api_session_java7.dto.company.CompanyResponseView;
import com.example.spring_rest_api_session_java7.entities.Company;
import com.example.spring_rest_api_session_java7.mapper.ViewMapper;
import com.example.spring_rest_api_session_java7.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceN {
    private final CompanyRepository repository;
    private final ViewMapper viewMapper;

    public CompanyResponseView getAllCompany(String text, int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        CompanyResponseView personResponseView = new CompanyResponseView();
        personResponseView.setCompanyResponses(view(search(text,pageable)));
        return personResponseView;
    }
    public List <CompanyResponse> view (List<Company> company){
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for(Company p : company){
            companyResponses.add(viewMapper.companyResponses(p));
        }
        return companyResponses;
    }
    public List<Company> search(String name, Pageable pageable){
        String text = name == null ? "":name;
        return repository.searchPagination(text.toUpperCase(),pageable);

    }
}

