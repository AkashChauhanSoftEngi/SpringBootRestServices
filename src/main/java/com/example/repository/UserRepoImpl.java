package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo{

	@Autowired
	@PersistenceContext
	EntityManager em;
	
	@Override
	public User findUserById(Long id) {
		return em.find(User.class,id);
	}
}
