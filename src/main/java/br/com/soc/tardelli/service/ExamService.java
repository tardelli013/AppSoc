package br.com.soc.tardelli.service;

import br.com.soc.tardelli.Utils.MapperUtils;
import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.repository.ExamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExamService {

    @Autowired
    private ExamDAO examDAO;

    public void putExams() {
        examDAO.insertBatch();
    }

    public List<Exam> retrieveExams() {
        return MapperUtils.mapExamType(examDAO.getExams());
    }

    public Exam findById(int id) {
        String q = "id:" + id;
        List<Exam> exams = findExam(q);
        return exams.size() > 0 ? exams.get(0) : null;
    }

    public List<Exam> findExam(String q) {
        Map<String, String> parameterMap = MapperUtils.buildParameterMap(q);

        return MapperUtils.mapExamType(examDAO.getExams(parameterMap));
    }

    public Exam updateExam(Exam exam) {
        return examDAO.update(exam);
    }

    public Exam insertExam(Exam exam) {
        return examDAO.insert(exam);
    }

    public void deleteExam(Integer id) {
        examDAO.delete(id);
    }
}
