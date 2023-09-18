package pro.sky.MasterMindCourseWorkTwo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.server.MethodNotAllowedException;
import pro.sky.MasterMindCourseWorkTwo.Exception.EmptyArrayException;
import pro.sky.MasterMindCourseWorkTwo.Exception.MathQuestionException;
import pro.sky.MasterMindCourseWorkTwo.entity.Question;
import pro.sky.MasterMindCourseWorkTwo.repository.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Component
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();
    private Question[] arr = new Question[]{new Question("Остаток от деления",
            "Пример:11 % 5 — такое выражение равно единице, так как остаток единица."),
            new Question("Проценты",
                    "Пример: Как найти 120% от числа 200 * 1.2 = 240"),
            new Question("Как изучать математику",
                    "В освоении математики есть два уровня понимания." +
                            " Первый уровень — идейный. " +
                            "Это осознание того, для чего нужны определенные объекты," +
                            " какая задача решается и где это используется." +
                            " Второй уровень понимания — детальный; это подробное изучение подробностей решения задачи. " +
                            "Иногда нужно разобраться в задаче на детальном уровня понимания," +
                            " но в большинстве случаев — достаточно идейного."),
            new Question("Дискретная математика",
                    "Область математики, которая занимается дискретными структурами " +
                            "(например: графами, автоматами, утверждениями в логике). " +
                            "Основное ее отличие от обычной математики, которую вы изучали в школе," +
                            " — ее объекты не могут изменяться так же гладко, как и вещественные числа."),
            new Question("Логика",
                    "Это наука о формальных системах и доказательствах. " +
                            "Она лежит в основе компьютерных наук, ведь любой язык программирования" +
                            " — формальная система. " +
                            "Но не нужно заглядывать глубоко в теорию, чтобы найти применение этой науке в написании программ," +
                            " да и вообще в решении задач"),
            new Question("Комбинаторика",
                    "Комбинаторика изучает разные дискретные множества и отношения их элементов." +
                            " Наиболее часто встречаемая программистами комбинаторная задача — вывести количество элементов, " +
                            "которые необходимо перебрать, чтобы получить решение в зависимости от некоторых параметров." +
                            " Таким образом вы можете вывести асимптотическую сложность алгоритма."),
            new Question("Теория вероятностей",
                    "Теория вероятности делится на две части: дискретную и непрерывную." +
                            " Хотя в теории дискретная — это подкласс непрерывной, методы решения задач несколько различаются. " +
                            "Опять же лучше начинать с простого — дискретная теория вероятности часто сводится к комбинаторным задачам." +
                            " И теоретическая часть у дискретной формулируется проще.")
    };

    public void setArr(Question[] arr) {
        this.arr = arr;
    }

    @Override
    public Question add(String question, String answer){
        throw new MathQuestionException();
    }
    @Override
    public Question add(Question question){
        throw new MathQuestionException();
    }

    public Question remove(Question question){
        throw new MathQuestionException();
    }

    public Collection<Question> getAll(){
        throw new MathQuestionException();
    }


    public Question getRandomQuestion(){
        return  arr[random.nextInt(arr.length)];
    }
    public int getSize(){
        return  arr.length;
    }

}
