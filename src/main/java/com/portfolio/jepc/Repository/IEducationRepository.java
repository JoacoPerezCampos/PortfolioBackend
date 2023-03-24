package com.portfolio.jepc.Repository;

import com.portfolio.jepc.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer>{
    public Optional<Education> findByEdName (String edName);
    public boolean existsByEdName (String edName);
    
}
