package com.portfolio.jepc.Security.Service;

import com.portfolio.jepc.Security.Entity.User;
import com.portfolio.jepc.Security.Repository.IUserRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public Optional<User> getByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return iUserRepository.existsByUsername(username);
    }

    public boolean existsByUserEmail(String userEmail) {
        return iUserRepository.existsByUserEmail(userEmail);
    }

    public void save(User user) {
        iUserRepository.save(user);
    }

}
