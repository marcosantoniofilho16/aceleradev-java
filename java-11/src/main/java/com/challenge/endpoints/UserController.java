package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable Long id) {

		return userService.findById(id);
	}

	@GetMapping
	public List<User> findByAccelerationNameAndCompanyId(@RequestParam(required = false) String accelerationName,
			@RequestParam(required = false) Long companyId) {
		
		if (accelerationName != null)
			return userService.findByAccelerationName(accelerationName);
		
		if (companyId != null)
			return userService.findByCompanyId(companyId);

		return userService.findAll();
	}

}
