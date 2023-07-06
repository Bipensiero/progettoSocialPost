package it.jaita88.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jaita88.model.UserT;
import it.jaita88.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private final UserRepository userRepository;
	
	
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@GetMapping
	public List<UserT> getAllUsers(){
		 return userRepository.findAll();
	}
	
	@PostMapping
	public UserT createUser(@RequestBody UserT userT) {
		return userRepository.save(userT);
	}
	
	@GetMapping("/{userId}")
	public UserT getUserById(@PathVariable Long userId) {
		return userRepository.findById(userId).get();
	}
}
