package pro.sky.MasterMindCourseWorkTwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.MasterMindCourseWorkTwo.entity.Question;
import pro.sky.MasterMindCourseWorkTwo.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class  ExamController {
    private final ExaminerService examinerService;
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount){
        return examinerService.getQuestion(amount);
    }
}
