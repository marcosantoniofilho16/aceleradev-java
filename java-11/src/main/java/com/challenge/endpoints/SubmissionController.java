package com.challenge.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/submission")
@AllArgsConstructor
public class SubmissionController {

	private SubmissionService submissionService;

	@GetMapping
	public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam(required = false) Long challengeId,
			@RequestParam(required = false) Long accelerationId) {

		if (challengeId != null && accelerationId != null)
			return this.mapToSubmissionDTO(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));

		return this.mapToSubmissionDTO(submissionService.findAll());
	}
	
	private List<SubmissionDTO> mapToSubmissionDTO(List<Submission> submission) {
		return SubmissionMapper.INSTANCE.map(submission);
	}

}
