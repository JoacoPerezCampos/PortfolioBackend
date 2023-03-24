package com.portfolio.jepc.Security.Repository;

import com.portfolio.jepc.Security.Entity.Role;
import com.portfolio.jepc.Security.Enums.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRoleName(RoleName roleName);
}
