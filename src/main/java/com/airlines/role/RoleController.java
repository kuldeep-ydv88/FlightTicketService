package com.airlines.role;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kuldeep yadav
 */

@RestController
@Slf4j
@RequestMapping(value = "roles")
public record RoleController(RoleService roleService) {
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("name/{roleName}")
    public ResponseEntity<Role> findRoleByName(@PathVariable("roleName") String roleName) {
        return ResponseEntity.ok(roleService.findByName(roleName));
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable("id") String roleId) {
        return ResponseEntity.ok(roleService.findById(roleId));
    }
}
