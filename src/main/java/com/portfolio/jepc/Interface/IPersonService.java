package com.portfolio.jepc.Interface;

import com.portfolio.jepc.Entity.Person;
import java.util.List;


public interface IPersonService{
    
    public List<Person> getPerson();
    
    public void savePerson(Person person);
    
    public void deletePerson (int id);
    
    public Person findPerson (int id);

    public boolean existsById(int id);

}
