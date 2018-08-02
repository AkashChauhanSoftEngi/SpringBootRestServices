package com.example.service;

import java.util.List;

import com.example.dto.UserDto;

public interface UserService {
	UserDto saveUser(UserDto inUserDto);
	public List<UserDto> getAllUsers();
	public UserDto findUserById(Long id);
	public UserDto updateUser(UserDto inUserDto);
	public int deleteUser(Long userId);
}
