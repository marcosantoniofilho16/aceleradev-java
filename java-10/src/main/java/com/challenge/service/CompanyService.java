package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements CompanyServiceInterface {
	
	private CompanyRepository companyRepository;

	@Override
	public Company save(Company object) {
		return companyRepository.save(object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		return companyRepository.findById(id);
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		return companyRepository.findByAccelerationId(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		return companyRepository.findByUserId(userId);
	}

}
