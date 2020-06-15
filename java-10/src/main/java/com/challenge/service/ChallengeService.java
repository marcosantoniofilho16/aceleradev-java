package com.challenge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallegeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChallengeService implements ChallengeServiceInterface {
	
	private ChallegeRepository challegeRepository;

	@Override
	public Challenge save(Challenge object) {
		return challegeRepository.save(object);
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		return challegeRepository.findByAccelerationIdAndUserId(accelerationId, userId);
	}

}
