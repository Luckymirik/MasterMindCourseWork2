package pro.sky.MasterMindCourseWorkTwo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.MasterMindCourseWorkTwo.Exception.AmountMoreThanRequiredException;
import pro.sky.MasterMindCourseWorkTwo.entity.Question;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @BeforeEach
    public void beforeEach() {
        examinerService = new ExaminerServiceImpl(javaQuestionService,mathQuestionService);
        Mockito.when(javaQuestionService.getAll()).thenReturn(
                List.of(
                        new Question("●\t@Component", "Spring определяет этот класс как кандидата для создания bean"),
                        new Question("●\t@Service ", " класс содержит бизнес-логику и вызывает методы на уровне хранилища." +
                                " Ничем не отличается от классов с @Component"),
                        new Question("●\t@Controller ", "указывает, что класс выполняет роль контроллера MVC. " +
                                "Диспетчер сервлетов просматривает такие классы для поиска @RequestMapping")
                )
        );
        Mockito.when(mathQuestionService.getAll()).thenReturn(
                List.of(
                        new Question("Какую часть оборота вы прошли," +
                                " если встали лицом на запад и повернулись по часовой стрелке лицом на юг?","¾")
                )
                );
    }



    @Test
    void getQuestion() {
        Assertions.assertThrows(AmountMoreThanRequiredException.class,
                ()->examinerService.getQuestion(5));
    }
}