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

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    EditText questionText;
    TextView scoreText;
    double score = 10;

    Answer[] answers = new Answer[4];
    MultChoice pool1 = new MultChoice();
    MultChoice question = new MultChoice();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        answers[0] = new Answer("(1, 4)", false);
        answers[1] = new Answer("(-1, 4)", false);
        answers[2] = new Answer("(1, -4)", true);
        answers[3] = new Answer("(-1, 0)", false);

        pool1.setChoice(answers);

        question.setQuestion("y = -4x + 7");



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        questionText = (EditText)findViewById(R.id.editText);
        questionText.setText(question.getQuestion());


        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        // Answer buttons
        button = (Button)findViewById(R.id.button);
        pool1.setupButton(button, 0, this);

        button2 = (Button)findViewById(R.id.button2);
        pool1.setupButton(button2, 1, this);

        button3 = (Button)findViewById(R.id.button3);
        pool1.setupButton(button3, 2, this);

        button4 = (Button)findViewById(R.id.button4);
        pool1.setupButton(button4, 1, this);


        scoreText = (TextView) findViewById(R.id.scoreText);
    }

    private void button1Click(){
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    private void buttonClick(Button button, Boolean correctness){
        button.setEnabled(false);
        if (!correctness) {
            button.setBackgroundColor(Color.RED);
            score = score - 2.5;
        } else {
            button.setBackgroundColor(Color.GREEN);
            scoreText.setText("Score: " + Double.toString(score));

            this.button.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            Toast.makeText(Activity2.this,
                    "Correct!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                buttonClick(button, answers[0].getCorrectness());
                break;

            case R.id.button1:
                button1Click();
                break;

            case R.id.button2:
                buttonClick(button2, answers[1].getCorrectness());
                break;

            case R.id.button3:
                buttonClick(button3, answers[2].getCorrectness());
                break;

            case R.id.button4:
                buttonClick(button4, answers[3].getCorrectness());
                break;
        }

    }
}
