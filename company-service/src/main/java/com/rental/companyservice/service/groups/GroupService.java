package com.rental.companyservice.service.groups;

import com.rental.companyservice.entity.Groups;
import com.rental.companyservice.repository.GroupsRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupService {
    private final GroupsRepo repository;
    private final GroupMapper mapper;

    GroupService(GroupsRepo repository, GroupMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GroupDto> list() {
        try {
            List<Groups> groups = repository.findAll();
            return mapper.map(groups);
        } catch (Exception e) {
            throw e;
        }
    }
}
