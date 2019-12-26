package service;

import org.springframework.web.multipart.MultipartFile;
import pojo.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by plq on 2019/12/21.
 */
public interface QuestionDao {

    public int deleteQuestionByid(String id);

    public List<Question> selectpage(HashMap map);
    /**
     * 导入
     * @return Map<String, Object>
     * @throws IOException
     * @throws IOException
     */
    Map<String, Object> upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, Question question) throws IOException;
}
