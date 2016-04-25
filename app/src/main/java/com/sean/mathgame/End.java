package com.sean.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * This implements the End class
 */
public class End extends AppCompatActivity implements View.OnClickListener {

    Button buttonRestartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        buttonRestartGame = (Button)findViewById(R.id.buttonRestartGame);
        buttonRestartGame.setOnClickListener(this);
    }

    /**
     * This will direct the user back to the MainActivity page if they want to play again
     */
    private void buttonRestartGameClick(){
        Intent intent = new Intent(End.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
}

    /**
     * This is run when the "New Game" button is pressed and initiates the buttonRestartGameClick method
     */
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonRestartGame:
                buttonRestartGameClick();
                break;
        }
    }
}
