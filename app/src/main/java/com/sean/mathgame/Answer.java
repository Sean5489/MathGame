package com.sean.mathgame;

public class Answer {
    public Answer()
    { }

    public Answer(String answer, Boolean correctness) {
        this.answer = answer;
        this.correctness = correctness;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getCorrectness() {
        return correctness;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrectness(Boolean correctness) {
        this.correctness = correctness;
    }

    private String answer;
    private Boolean correctness;
}
