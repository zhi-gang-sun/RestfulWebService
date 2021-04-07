package com.ibm.cio.dsw.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	@Autowired
	private UserDAOService userDAOService;

	@GetMapping(path = "/users/{id}")
	public User findOne(@PathVariable int id) {
		 User u = userDAOService.findOne(id);
		 
		 if(u ==null) {
			 throw new UserNotFoundException("id -" + id);
		 }
		 
		 //Resource<User> resource = new Resource(u);
		 
		// Controllerlink
		 
		 return u;
	}

	@GetMapping(path = "/users")
	public List<User> findAll() {
		return userDAOService.findAll();
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		userDAOService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		userDAOService.deleteById(id);
	}
}
