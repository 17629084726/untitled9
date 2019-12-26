package mapper;

import pojo.ExamScoer;

import java.util.HashMap;
import java.util.List;

/**
 * Created by plq on 2019/12/21.
 */
public interface ExamScoerMapper {
    public List<ExamScoer> selectpage(HashMap map);

    public  Integer Questioncount();

    public int deleteQuestionByid(Integer id);

    public int addExamScoer(ExamScoer ExamScoer);
}
