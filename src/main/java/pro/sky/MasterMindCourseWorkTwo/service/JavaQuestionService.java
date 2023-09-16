package pro.sky.MasterMindCourseWorkTwo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.MasterMindCourseWorkTwo.Exception.EmptyArrayException;
import pro.sky.MasterMindCourseWorkTwo.entity.Question;
import pro.sky.MasterMindCourseWorkTwo.repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
@Primary

public class JavaQuestionService implements QuestionService{


    private final Random random = new Random();
    private final QuestionRepository javaQuestionRepository;

    public JavaQuestionService(QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }
    @Override
    public Question add(String question, String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        return javaQuestionRepository.add(question);
    }

    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }
    public Collection<Question> getAll(){
        return javaQuestionRepository.getAll();
    }


    public Question getRandomQuestion(){
        Question[] arr = javaQuestionRepository.getAll().toArray(new Question[0]);
        if (arr.length==0){
            throw new EmptyArrayException();
        }
        return arr[random.nextInt(arr.length)];
    }

//    @Override
//    public int getSize() {
//        return 0;
//    }
}
