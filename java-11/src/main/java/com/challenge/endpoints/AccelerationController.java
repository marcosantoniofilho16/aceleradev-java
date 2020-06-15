package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/acceleration")
@AllArgsConstructor
public class AccelerationController {
	
	private AccelerationService accelerationService;
	
	@GetMapping("/{id}")
	public Optional<Acceleration> findById(@PathVariable Long id) {
		
		return accelerationService.findById(id);
	}
	
	@GetMapping
	public List<Acceleration> findByCompanyId(@RequestParam Long companyId) {
		
		return accelerationService.findByCompanyId(companyId);
	}

}
