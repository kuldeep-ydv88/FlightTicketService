package com.airlines.role;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author kuldeep
 */

@Service
public record RoleService(MongoTemplate mongoTemplate) {
    public Role createRole(Role role) {
        validateRoleName(role);
        Role existingRole = findByName(role.getName());
        if (Objects.isNull(existingRole)) {
            return mongoTemplate.save(role);
        } else {
            return existingRole;
        }
    }

    public Role findByName(String name) {
        Criteria criteria = Criteria.where("name").is(name.trim().toUpperCase());
        Query query = Query.query(criteria);
        return mongoTemplate.findOne(query, Role.class);
    }

    public List<Role> findAll() {
        return mongoTemplate.findAll(Role.class);
    }

    public Role findById(String roleId) {
        return mongoTemplate.findById(roleId, Role.class);
    }


    private void validateRoleName(Role role) {
        if (Objects.nonNull(role) && Objects.nonNull(role.getName()) && !Objects.equals(role.getName().trim(), "")) {
            if (!role.getName().toUpperCase().startsWith("ROLE_")) {
                role.setName("ROLE_" + role.getName().toUpperCase());
            } else {
                role.setName(role.getName().toUpperCase());
            }
        } else {
            throw new RoleException("Invalid roles name", HttpStatus.NOT_ACCEPTABLE.value());
        }
    }
}
