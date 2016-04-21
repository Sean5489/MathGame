package com.sean.mathgame;

import android.content.Intent;
import android.content.res.ColorStateList;
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

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    EditText questionText;
    TextView scoreText;
    double score;
    double scoreTotal;

    int questionNumber = 0;

    MultChoice pool0 = new MultChoice("y = -4x + 7", "(1, 4)", false, "(-1, 4)", false, "(1, -4)", true, "(-1, 0)", false);
    MultChoice pool1 = new MultChoice("3 x 5", "10", false, "15", true, "25", false, "35", false);
    MultChoice pool2 = new MultChoice("1 x 5", "1", false, "2", false, "3", false, "5", true);
    MultChoice pool3 = new MultChoice("20 x 4", "80", true, "75", false, "60", false, "150", false);

    MultChoice[] multChoicePool = new MultChoice[4];

    MultChoice currentQuestion = new MultChoice();

    double highestScore = 10 * multChoicePool.length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        questionText = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button1);
        // Answer buttons
        button  = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        multChoicePool[0] = pool0;
        multChoicePool[1] = pool1;
        multChoicePool[2] = pool2;
        multChoicePool[3] = pool3;

        questionNumber = 0;
        initializeActivityForNewQuestion(multChoicePool[questionNumber]);

        scoreText = (TextView) findViewById(R.id.scoreText);
    }

    private void button1Click(){
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /**
     * This method will
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

        currentQuestion = question;

        score = 10;
    }

    private void buttonClick(Button button, Boolean correctness) {
        button.setEnabled(false);
        if (!correctness) {
            button.setBackgroundColor(Color.RED);
            score = score - 2.5;
        } else {
            button.setBackgroundColor(Color.GREEN);
            scoreTotal = score + scoreTotal;
            scoreText.setText("Score: " + Double.toString(scoreTotal));

            this.button.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);

            questionNumber++;
            if (questionNumber < multChoicePool.length) {
                Toast.makeText(Activity2.this,
                        "Correct!", Toast.LENGTH_SHORT).show();
                initializeActivityForNewQuestion(multChoicePool[questionNumber]);
            } else {
                this.button.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

                Toast.makeText(Activity2.this,
                        "Congratulations! You have completed the game. Final score is " + scoreTotal + " out of a possible " + highestScore + " points.", Toast.LENGTH_LONG).show();
            }
        }
    }

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
