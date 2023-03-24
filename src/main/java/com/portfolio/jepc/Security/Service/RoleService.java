package com.portfolio.jepc.Security.Service;

import com.portfolio.jepc.Security.Entity.Role;
import com.portfolio.jepc.Security.Enums.RoleName;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.jepc.Security.Repository.IRoleRepository;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    IRoleRepository iRoleRepository;

    public Optional<Role> getByRoleName(RoleName roleName) {
        return iRoleRepository.findByRoleName(roleName);
    }

    public void save(Role role) {
        iRoleRepository.save(role);
    }
}
