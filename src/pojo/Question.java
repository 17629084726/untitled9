package pojo;

/**
 * Created by plq on 2019/12/21.
 */
public class Question {
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private String userName= "";
    private String userId= "";
    private String paperId= "";
    private String paperName= "";
    private String questionTime;
    private String Abstract= "";
    /**
     * 试题编号
     * db_column: questionId
     */
    private String questionId= "";

    /**
     * 试题
     * db_column: questionId
     */
    private String questionName= "";

    /**
     * 选项
     * db_column: questionId
     */
    private String questionTypeA= "";
    private String questionTypeB= "";
    private String questionTypeC= "";
    private String questionTypeD= "";
    /**
     * 答案
     * db_column: ANSWER
     */
    private String answer= "";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionTypeA() {
        return questionTypeA;
    }

    public void setQuestionTypeA(String questionTypeA) {
        this.questionTypeA = questionTypeA;
    }

    public String getQuestionTypeB() {
        return questionTypeB;
    }

    public void setQuestionTypeB(String questionTypeB) {
        this.questionTypeB = questionTypeB;
    }

    public String getQuestionTypeC() {
        return questionTypeC;
    }

    public void setQuestionTypeC(String questionTypeC) {
        this.questionTypeC = questionTypeC;
    }

    public String getQuestionTypeD() {
        return questionTypeD;
    }

    public void setQuestionTypeD(String questionTypeD) {
        this.questionTypeD = questionTypeD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(String questionTime) {
        this.questionTime = questionTime;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }
}
