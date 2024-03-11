package org.demo.student5.Student.repository;

import org.demo.student5.Student.models.ERole;
import org.demo.student5.Student.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);


}
