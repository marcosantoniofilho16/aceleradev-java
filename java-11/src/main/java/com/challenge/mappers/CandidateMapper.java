package com.challenge.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
	
	CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    @Mappings({
            @Mapping(source = "id.user.id", target = "userId"),
            @Mapping(source = "id.acceleration.id", target = "accelerationId"),
            @Mapping(source = "id.company.id", target = "companyId"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "status", target = "status")
    })
    CandidateDTO map(Candidate candidate);

    List<CandidateDTO> map(List<Candidate> candidates);


}
