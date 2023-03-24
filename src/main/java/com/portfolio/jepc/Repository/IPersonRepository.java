package com.portfolio.jepc.Repository;

import com.portfolio.jepc.Entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
   
    public Optional<Person> findByName(String name);
    
    public boolean existsByName(String name);

    public void deleteById(int id);

    public Optional<Person> findById(int id);
}
