package pojo;

/**
 * Created by plq on 2019/12/21.
 */
public class ExamScoer {
    /**
     * @Fields
     */
    private static final long serialVersionUID = 1L;

    /**
     * 考生编号
     * db_column: EXAMINEE_ID
     */
    private String userId;
    /**
     * 考生编号
     * db_column: EXAMINEE_ID
     */
    private String userName;

    /**
     * 试题编号
     * db_column: QUESTION_ID
     */
    private String questionId;

    /**
     * 开始时间
     * db_column: ANSWER
     */
    private String examTime;
    /**
     * 答案
     * db_column: ANSWER
     */
    private java.lang.String answer;

    /**
     * 得分
     * db_column: SCORE
     */
    private Integer examScoer;

    private String paperId;
    private String paperName;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getExamScoer() {
        return examScoer;
    }

    public void setExamScoer(Integer examScoer) {
        this.examScoer = examScoer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
