package com.sean.mathgame;
// This implements the Answer class
public class Answer {
    /**
     * This passses through two objects: one is a string for the answer and the other is a boolean called correctness
     * which is true if the answer is correct or false if incorrect
     * Additionally, it allows for the answer or correctness to be returned.
     */
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
