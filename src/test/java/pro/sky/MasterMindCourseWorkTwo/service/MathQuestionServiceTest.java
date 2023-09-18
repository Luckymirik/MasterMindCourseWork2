package pro.sky.MasterMindCourseWorkTwo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.MasterMindCourseWorkTwo.Exception.AmountMoreThanRequiredException;
import pro.sky.MasterMindCourseWorkTwo.Exception.MathQuestionException;
import pro.sky.MasterMindCourseWorkTwo.entity.Question;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class MathQuestionServiceTest {

    @InjectMocks
    private MathQuestionService mathQuestionService;

    @Test
    void add() {
        Assertions.assertThrows(MathQuestionException.class,
    ()-> mathQuestionService.add("Как еще называют периметр круга?","Окружность"));
    }
    @Test
    void remove() {
        Assertions.assertThrows(MathQuestionException.class,
                ()->mathQuestionService.remove(new Question(" Кто изобрел знак равенства '='?",
                "Роберт Рекорд")));
    }

    @Test
    void getAll() {
        Assertions.assertThrows(MathQuestionException.class,()->mathQuestionService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Assertions.assertNotNull(mathQuestionService.getRandomQuestion());
    }
}