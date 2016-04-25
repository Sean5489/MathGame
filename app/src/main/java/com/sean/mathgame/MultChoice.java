package com.sean.mathgame;

import android.widget.Button;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Created by Sean on 4/13/16.
 */
public class MultChoice {
    Answer[] choice;
    String question;

    MultChoice() {

    }

    MultChoice(String question) {
        this.question = question;
    }

    /**
     * This method will shuffle an array by shuffling each component of the array into a new position
     * It was chosen as it was simple to implement. It is a static so that it can be used in any class
     */
    static void shuffleArray(Object[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            Object a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    /**
     * This method combines the question string, the answer strings, and the correctness booleans for each answer into one
     * It also shuffles the answers around when it is called
     */
    MultChoice(String question, String answer0, Boolean correctness0, String answer1, Boolean correctness1, String answer2, Boolean correctness2, String answer3, Boolean correctness3) {
        this.question = question;
        choice = new Answer[4];

        choice[0] = new Answer(answer0, correctness0);
        choice[1] = new Answer(answer1, correctness1);
        choice[2] = new Answer(answer2, correctness2);
        choice[3] = new Answer(answer3, correctness3);

        shuffleArray(choice);
        for (int i = 0; i < choice.length; i++)
        {
            System.out.print(choice[i] + " ");
        }
        System.out.println();
    }


    public void setChoice(Answer[] answers) {
        choice = answers;
    }

    // This allows for an answer array to be set up
    public Answer[] getChoice() {
        return this.choice;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // This returns the question
    public String getQuestion(){
        return this.question;
    }

}
