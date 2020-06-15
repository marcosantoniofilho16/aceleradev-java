package com.challenge.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {
	
	private UserRepository userRepository;

	@Override
	public User save(User object) {
		object.setCreatedAt(LocalDateTime.now());
		return userRepository.save(object);
	}

	@Override
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		return userRepository.findByAccelerationName(name);
	}

	@Override
	public List<User> findByCompanyId(Long companyId) {
		return userRepository.findByCompanyId(companyId);
	}

}
