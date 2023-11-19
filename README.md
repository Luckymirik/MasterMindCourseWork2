# MasterMindCourseWork2
 Educational project. 2nd year coursework
1. Delete MathQuestionRepository.
2. Now attempts to add, delete and get all questions in mathematics should throw an exception with the status 405 Method Not Allowed
3. Add on-the-fly generation of math questions to the getRandomQuestion method of the MathQuestionService service. This is possible using the previously mentioned Random class.
4. Get rid of fields for each question service in ExaminerServiceImpl. Collect them into a collection. Rework the way the question collection is assembled to reflect this change.
