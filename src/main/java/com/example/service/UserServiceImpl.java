package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto saveUser(UserDto inUserDto) {
		User outUser = new User();
		BeanUtils.copyProperties(inUserDto, outUser);
		outUser = userRepository.save(outUser);
		BeanUtils.copyProperties(outUser, inUserDto);
		return inUserDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		List<UserDto> allDtoUsers = new ArrayList<>();
		for (com.example.entity.User user : allUsers) {
			UserDto newDtoUser = new UserDto();
			BeanUtils.copyProperties(user, newDtoUser);
			allDtoUsers.add(newDtoUser);
		}
		return allDtoUsers;
	}

	@Override
	public UserDto findUserById(Long id) {
		com.example.entity.User dbUser = userRepository.findUserById(id);
		UserDto userDto = null;
		if (dbUser != null) {
			userDto = new UserDto();
			BeanUtils.copyProperties(dbUser, userDto);
		}
		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto inUserDto) {
		com.example.entity.User dbUser = userRepository.findUserById(inUserDto.getId());
		if (dbUser != null) {
			dbUser.setFirstName(inUserDto.getFirstName());
			dbUser.setInstitute(inUserDto.getInstitute());
			dbUser.setLastName(inUserDto.getLastName());
			userRepository.save(dbUser);
			BeanUtils.copyProperties(dbUser, inUserDto);
			return inUserDto;
		} else {
			return null;
		}
	}

	@Override
	public int deleteUser(Long userId) {
		try {
			com.example.entity.User dbUser = userRepository.findUserById(userId);
			if (dbUser == null) {
				return -1;
			} else {
				userRepository.deleteById(userId);
				return 1;
			}

		} catch (Exception e) {

		}
		return 0;

	}
}
