package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import entity.entity1;
import repository.repository;

public class service {
    
	@Autowired
	private repository rep;
	
	public List <entity1> getAllUsers()
	{
		return rep.findAll();
	}
	
	public Optional<entity1> getUserById(Long id){
		
		return rep.findById(id);
	}
	
	public entity1 createUser(entity1 entity)
	{
		return rep.save(entity);
	}
	
	public entity1 updateUser(Long id,entity1 userDetails)
	{
		entity1 entity=rep.findById(id).orElseThrow() -> new RuntimeException("User not found"));
		entity.setName(rep.getName());
		entity.setEmail(rep.getEmail());
		
		return rep.save(entity);
	}
	public void deleteUser(Long id) {
		rep.deleteById(id);
	}
	
	
}
