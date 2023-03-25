package com.portfolio.jepc.Repository;

import com.portfolio.jepc.Entity.HSSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHSSkillsRepository extends JpaRepository<HSSkills, Integer> {

    Optional<HSSkills> findByHsName(String hsName);

    public boolean existsByHsName(String hsName);

}
