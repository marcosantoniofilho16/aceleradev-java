package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmissionService implements SubmissionServiceInterface {
	
	private SubmissionRepository submissionRepository;

	@Override
	public Submission save(Submission object) {
		return submissionRepository.save(object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		return submissionRepository.findHigherScoreByChallengeId(challengeId).orElse(BigDecimal.ZERO);
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}

}
