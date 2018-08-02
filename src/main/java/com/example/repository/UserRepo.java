package com.example.repository;

import com.example.entity.User;

public interface UserRepo {
	User findUserById(Long Id);
}
