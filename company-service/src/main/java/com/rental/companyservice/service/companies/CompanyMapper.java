package com.rental.companyservice.service.companies;

import com.rental.companyservice.entity.Company;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapper {
    private final ModelMapper mapper;

    CompanyMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CompanyDto map(Company company) {
        return mapper.map(company, CompanyDto.class);
    }

    public List<CompanyDto> map(List<Company> companies) {
        List<CompanyDto> _companies = new ArrayList<>();

        for(Company company : companies) {
            _companies.add(mapper.map(company, CompanyDto.class));
        }

        return _companies;
    }

}
