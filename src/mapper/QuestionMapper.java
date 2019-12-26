package mapper;

import pojo.Question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by plq on 2019/12/21.
 */
public interface QuestionMapper {
    public List<Question> selectpage(HashMap map);

    public  Integer Questioncount();

    public List<Question> selectpaperId(String paperId);

    public int deleteQuestionByid(String id);

    public int addQuestion(Question question);

    public  int updateQuestion(Question question);

}
