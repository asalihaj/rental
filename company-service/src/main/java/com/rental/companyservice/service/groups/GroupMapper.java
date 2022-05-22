package com.rental.companyservice.service.groups;

import com.rental.companyservice.entity.AccessList;
import com.rental.companyservice.entity.Employee;
import com.rental.companyservice.entity.Groups;
import com.rental.companyservice.service.employees.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapper {
    private final ModelMapper mapper;

    GroupMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public List<GroupDto> map(List<Groups> groups) {
        List<GroupDto> _groups = new ArrayList<>();
        TypeMap<Groups, GroupDto> typeMap = mapper.createTypeMap(Groups.class, GroupDto.class);
        //typeMap.addMapping(AccessList::getKey::getName, GroupDto::setAccessList);

        for(Groups group : groups) {
            _groups.add(mapper.map(group, GroupDto.class));
        }
        return _groups;
    }
}
