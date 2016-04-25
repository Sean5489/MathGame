package com.sean.mathgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This implements the Addition class
 */
public class Addition extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    EditText questionText;
    TextView scoreText;
    double score;
    double scoreTotal;
    Timer timer = new Timer();

    int questionNumber = 0;

    /**
     * This sets up questions and answers for the addition portion of the game
     */
    MultChoice[] multChoiceAddition = new MultChoice[4];
    MultChoice addition0 = new MultChoice("10 + 11", "20", false, "22", false, "21", true, "19", false);
    MultChoice addition1 = new MultChoice("7 + 5", "10", false, "12", true, "15", false, "8", false);
    MultChoice addition2 = new MultChoice("17 + 9", "25", false, "28", false, "23", false, "26", true);
    MultChoice addition3 = new MultChoice("34 + 13", "47", true, "55", false, "39", false, "44", false);

    MultChoice currentQuestion = new MultChoice();

    // This sets the highest score for the congratulatory toast at the end
    double highestScore = 10 * multChoiceAddition.length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        //Allows for question to be edited
        questionText = (EditText) findViewById(R.id.editText);

        //Back button
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        // Answer buttons
        button  = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        //Establishes an array of question sets
        multChoiceAddition[0] = addition0;
        multChoiceAddition[1] = addition1;
        multChoiceAddition[2] = addition2;
        multChoiceAddition[3] = addition3;

        //Shuffles questions and answers
        MultChoice.shuffleArray(multChoiceAddition);

        questionNumber = 0;
        initializeActivityForNewQuestion(multChoiceAddition[questionNumber]);

        //Allows for score to be edited
        scoreText = (TextView) findViewById(R.id.scoreText);
    }

    /**
     * This method allows for the Back button to bring the user back to the main screen
     */
    private void button1Click(){
        Intent intent = new Intent(Addition.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /**
     * This method displays the question and the answer text on the buttons.
     * It sets the answer buttons to a light gray color and re-enables them.
     * Finally, it sets the question set to the variable currentQuestion and resets the score of the question set to 10.
     */

    private void initializeActivityForNewQuestion(MultChoice question) {
        questionText.setText(question.getQuestion());

        button.setText(question.getChoice()[0].getAnswer());
        button2.setText(question.getChoice()[1].getAnswer());
        button3.setText(question.getChoice()[2].getAnswer());
        button4.setText(question.getChoice()[3].getAnswer());

        button.setBackgroundColor(Color.LTGRAY);
        button2.setBackgroundColor(Color.LTGRAY);
        button3.setBackgroundColor(Color.LTGRAY);
        button4.setBackgroundColor(Color.LTGRAY);

        button.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);

        currentQuestion = question;

        score = 10;
    }

    /**
     * @param button Passes the pressed answer button, which is then disabled
     * @param correctness Boolean which is true if answer is correct or false if incorrect for the given question
     * If the correctness boolean is false, the button is set to a red background and the score is subtracted by 2.5
     * If the correctness boolean is true, the button is set to a green background, the score is updated,
     *  all of the buttons are set to false, and the question number is incremented by one
     */
    private void buttonClick(Button button, Boolean correctness) {
        button.setEnabled(false);
        if (!correctness) {
            button.setBackgroundColor(Color.RED);
            score = score - 2.5;
        } else {
            button.setBackgroundColor(Color.GREEN);
            scoreTotal = score + scoreTotal;
            scoreText.setText("Score: " + Double.toString(scoreTotal));
            this.button.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            questionNumber++;
            /**
             * If the question number is less than the number of questions in the array, a toast appears which says "Correct!",
             *  and a 1.5 second timer is run before a new question set appears.
             * If the question number is equal to the number of questions in the array, a congratulatory toast appears and
             *  a 1.5 second timer is run before proceeding to the End activity.
             */
            if (questionNumber < multChoiceAddition.length) {
                Toast.makeText(Addition.this,
                        "Correct!", Toast.LENGTH_SHORT).show();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initializeActivityForNewQuestion(multChoiceAddition[questionNumber]);
                            }
                        });
                    }
                }, 1500);
            } else {

                Toast.makeText(Addition.this,
                        "Congratulations! You have completed the game. Final score is " + scoreTotal + " out of a possible " + highestScore + " points.", Toast.LENGTH_LONG).show();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Addition.this, End.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        });
                    }
                }, 1500);
            }
        }
    }

    /**
     * This method is run when a button is pressed. It passes each button press to the buttonClick method (with the
     * exception of button1, which is the back button)
     */
    public void onClick(View v) {
        Answer[] answerForCurrentQuestion = currentQuestion.getChoice();

        switch (v.getId())
        {
            case R.id.button:
                buttonClick(button, answerForCurrentQuestion[0].getCorrectness());
                break;

            case R.id.button1:
                button1Click();
                break;

            case R.id.button2:
                buttonClick(button2, answerForCurrentQuestion[1].getCorrectness());
                break;

            case R.id.button3:
                buttonClick(button3, answerForCurrentQuestion[2].getCorrectness());
                break;

            case R.id.button4:
                buttonClick(button4, answerForCurrentQuestion[3].getCorrectness());
                break;
        }

    }
}
