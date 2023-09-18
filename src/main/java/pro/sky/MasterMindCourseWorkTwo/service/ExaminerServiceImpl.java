package pro.sky.MasterMindCourseWorkTwo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.MasterMindCourseWorkTwo.Exception.AmountMoreThanRequiredException;
import pro.sky.MasterMindCourseWorkTwo.entity.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;
    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        questionServices = new ArrayList<>();
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
    }


    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> randomQuestion = new HashSet<>();
        if (amount < 0 || amount > questionServices.get(0).getSize()
                +questionServices.get(1).getSize()){
            throw new AmountMoreThanRequiredException();
        }
        while (randomQuestion.size() < amount) {
            if(random.nextBoolean()) {
                randomQuestion.add(questionServices.get(0).getRandomQuestion());
            }else{
                randomQuestion.add(questionServices.get(1).getRandomQuestion());
            }
        }
        return Collections.unmodifiableSet(randomQuestion);
    }
}
