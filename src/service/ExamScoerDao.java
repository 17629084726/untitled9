package service;

import pojo.ExamScoer;
import pojo.Question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by plq on 2019/12/22.
 */
public interface ExamScoerDao {

    public int deleteQuestionByid(Integer id);

    public List<ExamScoer> selectpage(HashMap map);

    public List<Question> selectpaperId(String paperId);
}
