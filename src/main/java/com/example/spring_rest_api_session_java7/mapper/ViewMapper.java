package com.example.spring_rest_api_session_java7.mapper;


import com.example.spring_rest_api_session_java7.dto.company.CompanyResponse;
import com.example.spring_rest_api_session_java7.entities.Company;
import org.springframework.stereotype.Component;

/**
 * author: Ulansky
 */
@Component
public class ViewMapper {

  public CompanyResponse companyResponses(Company company){
      if(company == null){
       return null;
      }
      CompanyResponse companyResponse = new CompanyResponse();
      companyResponse.setId(company.getId());
      companyResponse.setCompanyName(company.getCompanyName());
      companyResponse.setLocatedCountry(company.getLocatedCountry());
      companyResponse.setNumberOfStudents(company.getNumberOfStudents());
      return companyResponse;
  }

}
