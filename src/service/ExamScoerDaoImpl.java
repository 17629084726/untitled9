package service;

import mapper.ExamScoerMapper;
import mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.ExamScoer;
import pojo.Question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by plq on 2019/12/22.
 */
@Service
public class ExamScoerDaoImpl implements ExamScoerDao{
    @Autowired
    private ExamScoerMapper ExamScoerMapper;

    @Autowired
    private QuestionMapper QuestionMapper;
    @Override
    public int deleteQuestionByid(Integer id) {

        return 0;
    }

    @Override
    public List<ExamScoer> selectpage(HashMap map) {
        return ExamScoerMapper.selectpage(map);
    }

    @Override
    public List<Question> selectpaperId(String paperId) {
        return QuestionMapper.selectpaperId(paperId);
    }
}
