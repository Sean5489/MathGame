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
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView scoreText;
    double score = 10;

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

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);

        scoreText = (TextView) findViewById(R.id.scoreText);
    }

    private void button1Click(){
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    private void buttonClick(){
        button.setBackgroundColor(Color.RED);
        button.setEnabled(false);
        score = score - 2.5;
    }

    private void button2Click(){
        button2.setBackgroundColor(Color.RED);
        button2.setEnabled(false);
        score = score - 2.5;
    }

    private void button3Click(){
        // Sean update this code
        button3.setBackgroundColor(Color.GREEN);
        scoreText.setText("Score: " + Double.toString(score));
        Toast.makeText(Activity2.this,
                "Correct!", Toast.LENGTH_SHORT).show();
    }

    private void button4Click() {
        button4.setBackgroundColor(Color.RED);
        button4.setEnabled(false);
        score = score - 2.5;
    }


    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                buttonClick();
                break;

            case R.id.button1:
                button1Click();
                break;

            case R.id.button2:
                button2Click();
                break;

            case R.id.button3:
                button3Click();
                break;

            case R.id.button4:
                button4Click();
                break;
        }

    }
}
