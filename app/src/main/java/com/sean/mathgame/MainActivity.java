package com.sean.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

/**
 * This implements the MainActivity class
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd;
    Button buttonSubtract;
    Button buttonMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        /**
         * This establishes the three buttons in the activity: addition, subtraction, and multiplication
         */
        buttonAdd = (Button)findViewById(R.id.buttonAddition);
        buttonAdd.setOnClickListener(this);

        buttonSubtract = (Button)findViewById(R.id.buttonSubtraction);
        buttonSubtract.setOnClickListener(this);

        buttonMultiply = (Button)findViewById(R.id.buttonMultiplication);
        buttonMultiply.setOnClickListener(this);
    }

    /**
     * These direct the user to their selected math operation after the button is pressed
     */
    private void buttonAddClick(){
        startActivity(new Intent("MathGame.Addition"));

    }

    private void buttonSubtractClick(){
        startActivity(new Intent("MathGame.Subtraction"));

    }

    private void buttonMultiplyClick(){
        startActivity(new Intent("MathGame.Multiplication"));

    }

    /**
     * This is run for each button press, and starts the respective method for the given button
     */
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonAddition:
                buttonAddClick();
                break;

            case R.id.buttonSubtraction:
                buttonSubtractClick();
                break;

            case R.id.buttonMultiplication:
                buttonMultiplyClick();
                break;

        }
    }
}
