package com.sean.mathgame;

public class Question {
    private String question;
    private Answer ans1;
    private Answer ans2;
    private Answer ans3;
    private Answer ans4;

    public Question()
    { }

    public Question(String question, Answer ans1, Answer ans2, Answer ans3, Answer ans4){
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAns1(Answer ans1){
        this.ans1 = ans1;
    }

    public void setAns2(Answer ans2){
        this.ans2 = ans2;
    }

    public void setAns3(Answer ans3){
        this.ans3 = ans3;
    }

    public void setAns4(Answer ans4){
        this.ans4 = ans4;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAns1() {
        return ans1;
    }

    public Answer getAns2() {
        return ans2;
    }

    public Answer getAns3() {
        return ans3;
    }

    public Answer getAns4() {
        return ans4;
    }

}
