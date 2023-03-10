package com.example.spring_rest_api_session_java7.api;


import com.example.spring_rest_api_session_java7.dto.company.CompanyResponseView;
import com.example.spring_rest_api_session_java7.dto.company.CompanyRequest;
import com.example.spring_rest_api_session_java7.dto.company.CompanyResponse;
import com.example.spring_rest_api_session_java7.service.CompanyService;
import com.example.spring_rest_api_session_java7.service.impl.CompanyServiceN;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyServiceN companyServiceN;

    @GetMapping("/getAll")
    @PreAuthorize("isAuthenticated()")
    public List<CompanyResponse> getAllCompany(){
        return companyService.getAllCompanies();
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('Admin')")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) throws IOException {
        return companyService.addCompany(companyRequest);
    }

    @GetMapping("/findById/{id}")
    @PreAuthorize("isAuthenticated()")
    public CompanyResponse findById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public CompanyResponse deleteById(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }

    @PutMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) throws IOException {
        return companyService.updateCompany(id, companyRequest);
    }
    @GetMapping("/search")
    public CompanyResponseView getAllCompany(@RequestParam(name = "text", required = false) String text,
                                      int page, int size){
        return companyServiceN.getAllCompany(text,page,size);
    }

}