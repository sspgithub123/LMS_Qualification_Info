package com.bridgelabz.qualificationservice.service;

import com.bridgelabz.qualificationservice.dto.QualificationDto;
import com.bridgelabz.qualificationservice.model.QualificationInfo;

import java.util.List;

public interface IQualificationService {

    QualificationInfo addQualificationData(QualificationDto qualificationDto);

    List<QualificationInfo> getAllQualificationData();

    QualificationInfo getById(long id);

    List<QualificationInfo> getByCAndidateId(long id);

    QualificationInfo updateQualificationById(long id, QualificationDto qualificationDto);
    void deleteById(long id);
}
