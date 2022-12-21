package com.example.spring_rest_api_session_java7.dto.company;

import com.example.spring_rest_api_session_java7.dto.company.CompanyResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CompanyResponseView {

    List<CompanyResponse> companyResponses;
}
