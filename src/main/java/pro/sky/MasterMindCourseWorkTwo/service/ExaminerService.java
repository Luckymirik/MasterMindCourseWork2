package pro.sky.MasterMindCourseWorkTwo.service;

import pro.sky.MasterMindCourseWorkTwo.entity.Question;

import java.util.Collection;

public interface ExaminerService {
   Collection<Question> getQuestion(int amount);
}
