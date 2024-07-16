package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.entity1;
import service.service;
@RestController
@RequestMapping("/api/users")
public class controller {
	@Autowired
	private service serv;
	
	@GetMapping
	public List<entity1> getAllUsers(){
		
		return serv.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<entity1> getUserById(@PathVariable Long id)
	{
		return serv.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public entity1 createUser(@RequestBody entity1 entity)
	{
		return serv.createUser(entity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<entity1>updateUser(@PathVariable Long id,@RequestBody entity1 entity)
	{
		return ResponseEntity.ok(serv.updateUser(id, entity));
	}
    
	@DeleteMapping("/{id}")
	public ResponseEntity<void>ResponseEntity<Object> deleteuser(@PathVariable long id){
		serv.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
