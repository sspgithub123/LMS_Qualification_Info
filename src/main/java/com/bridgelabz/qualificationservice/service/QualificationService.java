package com.bridgelabz.qualificationservice.service;

import com.bridgelabz.qualificationservice.dto.QualificationDto;
import com.bridgelabz.qualificationservice.exception.CandidateException;
import com.bridgelabz.qualificationservice.model.QualificationInfo;
import com.bridgelabz.qualificationservice.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService implements IQualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;


    @Override
    public QualificationInfo addQualificationData(QualificationDto qualificationDto) {
        QualificationInfo qualificationInfo = new QualificationInfo(qualificationDto);
        return qualificationRepository.save(qualificationInfo);
    }

    @Override
    public List<QualificationInfo> getAllQualificationData() {
        List<QualificationInfo> qualificationInfoList = qualificationRepository.findAll();
        if (qualificationInfoList.isEmpty()) {
            throw new CandidateException(HttpStatus.NOT_FOUND, "There are no bank details added yet!!");
        } else
            return qualificationInfoList;
    }

    @Override
    public QualificationInfo getById(long id) {
        Optional<QualificationInfo> qualificationInfo = qualificationRepository.findById(id);
        if (qualificationInfo.isPresent()) {
            return qualificationInfo.get();
        } else
            throw new CandidateException(HttpStatus.NOT_FOUND, "This Id is not found! ");
    }

    @Override
    public List<QualificationInfo> getByCAndidateId(long id) {
        List <QualificationInfo> qualificationInfoList= qualificationRepository.findByCandidateId(id);
        if(qualificationInfoList.isEmpty()){
            throw new CandidateException(HttpStatus.NOT_FOUND,"this id is not found! ");
        }else
            return qualificationInfoList;
    }

    @Override
    public QualificationInfo updateQualificationById(long id, QualificationDto qualificationDto) {
        Optional<QualificationInfo> qualificationInfo = qualificationRepository.findById(id);
        if (qualificationInfo.isPresent()) {
            QualificationInfo qualificationInfo1 = new QualificationInfo(id, qualificationDto);
            qualificationRepository.save(qualificationInfo1);
            return qualificationInfo1;
        } else {
            throw new CandidateException(HttpStatus.NOT_FOUND, "BankDetails not found by this ID");
        }
    }

    @Override
    public void deleteById(long id) {
        Optional<QualificationInfo> candidate = qualificationRepository.findById(id);
        if (candidate.isPresent()) {
            qualificationRepository.deleteById(id);
        } else {
            throw new CandidateException("Candidate record does not found");
        }
    }
}