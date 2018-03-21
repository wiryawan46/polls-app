package id.wiryawan.jwttokenlogin.repository;


import id.wiryawan.jwttokenlogin.model.Role;
import id.wiryawan.jwttokenlogin.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}