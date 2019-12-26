package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.ExamScoer;
import service.ExamScoerDao;
import service.QuestionDao;
import tool.Tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by plq on 2019/12/22.
 */
@Controller
public class ExamScoerController {
    @Autowired
    private ExamScoerDao ExamScoerDao;

    @Autowired
    private QuestionDao QuestionDao;
    //列表
    @RequestMapping("/tableExamScoer.action")
    @ResponseBody
    public Map<String, Object> selectlayuitable(int page, int limit, String userName) {
        HashMap<String, Object> map = new HashMap<>();
        int pagestart = (page - 1) * limit;
        map.put("pagestart", pagestart);
        map.put("limit", limit);
        map.put("userName", userName);
//        map.put("loginName", loginName);
        List<ExamScoer> ExamScoer = ExamScoerDao.selectpage(map);
        //Integer pagecount = userDao.usercount();
        Map<String, Object> returnTable = Tool.testLayui(ExamScoer, page, limit);
        System.out.println("JSOn"+returnTable);
        //returnTable.put("count", pagecount);
        return returnTable;
    }



}
