package com.bridgelabz.qualificationservice.repository;

import com.bridgelabz.qualificationservice.model.QualificationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualificationRepository extends JpaRepository<QualificationInfo,Long> {

    List<QualificationInfo> findByCandidateId(long id);
}