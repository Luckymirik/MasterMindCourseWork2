package pro.sky.MasterMindCourseWorkTwo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pro.sky.MasterMindCourseWorkTwo.entity.Question;
import pro.sky.MasterMindCourseWorkTwo.repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;


@Component("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();
    private final QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        return mathQuestionRepository.add(question);
    }

    public Question remove(Question question){
            return mathQuestionRepository.remove(question);
    }
    public Collection<Question> getAll(){
        return mathQuestionRepository.getAll();
    }

    public Question getRandomQuestion(){
        Question[] arr = mathQuestionRepository.getAll().toArray(new Question[0]);
        return  arr[random.nextInt(arr.length)];


    }
}
