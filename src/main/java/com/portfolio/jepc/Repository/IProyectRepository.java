
package com.portfolio.jepc.Repository;

import com.portfolio.jepc.Entity.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectRepository extends JpaRepository<Proyect, Integer>{
    public Optional<Proyect> findBypName (String pName);
    public boolean existsBypName (String pName);
}
