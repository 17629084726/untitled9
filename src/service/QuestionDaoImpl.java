package service;

import mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pojo.Question;
import tool.ExcelUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by plq on 2019/12/21.
 */
@Service
public class QuestionDaoImpl implements QuestionDao{

    @Autowired
    private QuestionMapper QuestionMapper;
    /*
     * 文件导入（批量导入）
     * */
    @Override
    public Map<String, Object> upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response,Question Question) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, Object> map = new HashMap<>();
        if(file.isEmpty()){
            try {
                throw new Exception("文件不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream in =null;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<List<Object>> listob = null;
        try {
            listob = new ExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            //         System.out.println("遍历" + listob.get(i));
            Question question = new Question();
            Question j = null;

            question.setAbstract(Question.getAbstract());
            question.setPaperId(Question.getPaperId());
            question.setPaperName(Question.getPaperName());
            question.setUserName(Question.getUserName());
            question.setUserId(Question.getUserId());
            question.setQuestionTime(Question.getQuestionTime());
            question.setQuestionId(String.valueOf(lo.get(0)));
            question.setQuestionName(String.valueOf(lo.get(1)));
            question.setQuestionTypeA(String.valueOf(lo.get(2)));
            question.setQuestionTypeB(String.valueOf(lo.get(3)));
            question.setQuestionTypeC(String.valueOf(lo.get(4)));
            question.setQuestionTypeD(String.valueOf(lo.get(5)));
            question.setAnswer(String.valueOf(lo.get(6)));
            int o = QuestionMapper.addQuestion(question);
            if (o > 0) {
                map.put("msg","成功") ;
            }else {
                map.put("msg","失敗") ;
            }

        }
        return map;
    }
    @Override
    public List<Question> selectpage(HashMap map) {
        return QuestionMapper.selectpage(map);
    }

    @Override
    public int deleteQuestionByid(String id) {
        return QuestionMapper.deleteQuestionByid(id);
    }

}
