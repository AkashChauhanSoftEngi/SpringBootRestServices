package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public UserDto addUser(@RequestBody UserDto user) {
		System.out.println("Inside /user end point, to insert user");
		return userService.saveUser(user);
	}

	@GetMapping("/users")
	public ResponseEntity<Object> getAllUders() {
		System.out.println("inside /users end point, to get all users");
		List<UserDto> allUserDto;
		try {
			allUserDto = userService.getAllUsers();
			if (allUserDto.isEmpty()) {
				return new ResponseEntity<Object>("No Dto Users", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("There was an Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok().body(allUserDto);
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<UserDto> findUserById(@PathVariable(value = "id") Long userId){
		System.out.println("Inside users/{id} end point, to find user by id");
		UserDto userDto = userService.findUserById(userId);
		if(userDto == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(userDto);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long userId,@RequestBody UserDto inDTOUser) {
		inDTOUser.setId(userId);
		UserDto userDto = userService.updateUser(inDTOUser);
	    if(userDto == null) {
	        return ResponseEntity.ok().body(new String("Not Found"));
	    }
	    return ResponseEntity.ok().body(userDto);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long userId) {
		
		int  user = userService.deleteUser(userId);
	    if(user<=0) {
	        return ResponseEntity.ok().body(new String("Not Found"));
	    }
	    return ResponseEntity.ok().body(new String("Deleted SuccessFully"));
	}
}
