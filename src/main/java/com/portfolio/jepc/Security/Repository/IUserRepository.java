package com.portfolio.jepc.Security.Repository;

import com.portfolio.jepc.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String user);

    boolean existsByUsername(String username);

    boolean existsByUserEmail(String userEmail);

}
