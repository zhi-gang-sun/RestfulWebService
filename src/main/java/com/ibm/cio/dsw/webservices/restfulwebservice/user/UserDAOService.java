package com.ibm.cio.dsw.webservices.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(0, "Java", new Date()));
		users.add(new User(1, "Spark", new Date()));
		users.add(new User(2, "Kafka", new Date()));
		users.add(new User(3, "RabbitMQ", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}

	public User findOne(int id) {
		if(id >= users.size()) {
			return null;
		}
		return (User)users.get(id);
	}
	
	public void save(User user) {
		users.add(user);
		
	}
	
	public void deleteById(int id) {
		if(id < users.size()) {
			users.remove(id);
		}
	}
}
