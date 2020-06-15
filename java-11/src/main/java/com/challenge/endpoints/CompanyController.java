package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {
	
	private CompanyService companyService;
	
	@GetMapping("/{id}")
	public Optional<Company> findById(@PathVariable Long id) {

		return companyService.findById(id);
	}

	@GetMapping
	public List<Company> findByAccelerationIdAndUserId(@RequestParam(required = false) Long accelerationId,
			@RequestParam(required = false) Long userId) {
		
		if (accelerationId != null)
			return companyService.findByAccelerationId(accelerationId);
		
		if (userId != null)
			return companyService.findByUserId(userId);

		return companyService.findAll();
	}

}
