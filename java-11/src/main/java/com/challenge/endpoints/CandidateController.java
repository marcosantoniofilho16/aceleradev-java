package com.challenge.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
public class CandidateController {

	private CandidateService candidateService;

	@GetMapping("/{userId}/{accelerationId}/{companyId}")
	public CandidateDTO findById(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {

		return this.mapToCandidateDTO(candidateService.findById(userId, companyId, accelerationId).get());
	}

	@GetMapping
	public List<CandidateDTO> findByCompanyIdAndAccelerationId(@RequestParam(required = false) Long companyId,
			@RequestParam(required = false) Long accelerationId) {

		if (companyId != null)
			return this.mapToCandidateDTO(candidateService.findByCompanyId(companyId));

		if (accelerationId != null)
			return this.mapToCandidateDTO(candidateService.findByAccelerationId(accelerationId));

		return this.mapToCandidateDTO(candidateService.findAll());
	}
	
	private CandidateDTO mapToCandidateDTO(Candidate candidate) {
		return CandidateMapper.INSTANCE.map(candidate);
	}
	
	private List<CandidateDTO> mapToCandidateDTO(List<Candidate> candidates) {
		return CandidateMapper.INSTANCE.map(candidates);
	}

}
