package br.com.soc.tardelli.service;

import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.model.ExamTypesEnum;
import br.com.soc.tardelli.repository.ExamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamDAO examDAO;

    public void putExams() {
        examDAO.insertBatch();
    }

    public List<Exam> retrieveExams() {
        return mapExamType(examDAO.getExams());
    }

    private List<Exam> mapExamType(List<Exam> exams) {
        exams.forEach(exam -> exam.setExamType(ExamTypesEnum.getNameById(exam.getExamTypeId())));
        return exams;
    }

}
