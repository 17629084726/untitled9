package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.Question;
import service.ExamScoerDao;
import service.QuestionDao;
import tool.Tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by plq on 2019/12/21.
 */
@Controller
public class QusetionController {

    @Autowired
    private QuestionDao QuestionDao;

    @Autowired
    private ExamScoerDao ExamScoerDao;
    /**
     * 导入
     */
    @RequestMapping(value = "/upload.action")
    @ResponseBody
    public Map<String, Object> doImport (
            @RequestParam(value = "excelfile")MultipartFile file, HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "paperId")String paperId, @RequestParam(value = "Abstract")String Abstract, @RequestParam(value = "paperName")String paperName,
            @RequestParam(value = "userName")String userName,@RequestParam(value = "userId")String userId,@RequestParam(value = "questionTime")String questionTime
            )throws IOException{
        //file.getName().
        Question question = new Question();
        question.setPaperId(paperId);
        question.setUserName(userName);
        question.setUserId(userId);
        question.setPaperName(Abstract);
        question.setAbstract(Abstract);
        question.setPaperName(paperName);
        question.setQuestionTime(questionTime);
        //Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = QuestionDao.upload(file, request, response,question);

        return map2;

    }
    //列表
    @RequestMapping("/tablequestion.action")
    @ResponseBody
    public Map<String, Object> selectlayuitable(int page, int limit,String paperName) {
        HashMap<String, Object> map = new HashMap<>();
        int pagestart = (page - 1) * limit;
        map.put("pagestart", pagestart);
        map.put("limit", limit);
        map.put("paperName", paperName);
//        map.put("loginName", loginName);
        List<Question> questions = QuestionDao.selectpage(map);
        Map<String, Object> returnTable = Tool.testLayui(questions, page, limit);
        System.out.println("JSOn"+returnTable);
        //returnTable.put("count", pagecount);
        return returnTable;
    }

    //    单个删除
    @RequestMapping("/deleteQuestionByid.action")
    @ResponseBody
    public int deleteQuestionByid(@RequestParam(value = "id")String id) throws Exception {
        int  result =   QuestionDao.deleteQuestionByid(id);
        return  result;
    }

    //批量删除
    @RequestMapping("/deleteQuestionAll.action")
    @ResponseBody
    public int deleteAll(String user_ids)  {
        boolean b = user_ids.endsWith(",");
        if (b){
            user_ids = user_ids.substring(0,user_ids.length() - 1);
        }
        String[] ids = user_ids.split(",");
        int re = 0;
        for (String id: ids) {
            re = QuestionDao.deleteQuestionByid(id);
        }
        return re;
    }
    @RequestMapping("/tableBypaperId.action")
    @ResponseBody
    public Map<String, Object> selectpaperId(@RequestParam(value = "paperId")String paperId){
        HashMap<String, Object> map = new HashMap<>();
        List<Question> ExamScoer = ExamScoerDao.selectpaperId(paperId);
        Map<String, Object> returnTable = Tool.testLayui(ExamScoer, 0, 0);

        return returnTable;
    }
}
