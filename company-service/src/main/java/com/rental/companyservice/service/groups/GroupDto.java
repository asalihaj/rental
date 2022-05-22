package com.rental.companyservice.service.groups;

import com.rental.companyservice.entity.AccessList;
import com.rental.companyservice.entity.Claims;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Data
public class GroupDto {
    @Getter
    private UUID id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Set<AccessList> accessList;
}
