package com.example.diceroller1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String str_input;
    TextView number_guess;
    EditText input;
    Button submit;
    TextView textViews;
    int score = 0;
    TextView results;
    TextView Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        submit = findViewById(R.id.submit);
        textViews = findViewById(R.id.textViews);
        number_guess = findViewById(R.id.number_guess);
        submit.setOnClickListener(this);
        results = this.findViewById(R.id.results);
        Score = this.findViewById(R.id.Score);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {

        TextView tv = this.findViewById(R.id.textViews);

        Random r = new Random();
        int number = r.nextInt(6) + 1;

        tv.setText(Integer.toString(number));

    }


    @Override
    public void onClick(View v) {
        int guessed = v.getId();

        if (guessed == R.id.submit) {
            str_input = input.getText().toString().trim();
            String guess = str_input;
            number_guess.setText(guess);
        }
    }

    public void on_button_click_2(View view) {

        TextView number_guess = this.findViewById(R.id.number_guess);
        TextView textViews = this.findViewById(R.id.textViews);
        TextView results = this.findViewById(R.id.results);
        TextView Score = this.findViewById(R.id.Score);

        try {
            int guess = Integer.parseInt(number_guess.getText().toString());
            int roll = Integer.parseInt((textViews.getText().toString()));

            if (guess == roll) {
                score++;
                results.setText("Congrats");
                Score.setText(Integer.toString(score));

            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());

        }
    }

    public void on_button_click_3(View view) {


        TextView number_guess = this.findViewById(R.id.number_guess);
        TextView questionasked = this.findViewById(R.id.question);

        String question1 = "If you could go anywhere in the world, where would you go?";
        String question2 = "If you were stranded on a desert island, what three things would you want to take with you?";
        String question3 = "If you could eat only one food for the rest of your life, what would that be?";
        String question4 = "If you won a million dollars, what is the first thing you would buy?";
        String question5 = "If you could spend the day with one fictional character, who would it be?";
        String question6 = "If you found a magic lantern and a genie gave you three wishes, what would you wish?";


        int roll = Integer.parseInt(number_guess.getText().toString());

        switch (roll) {

            case 1:
                questionasked.setText(question1);
                break;

            case 2:
                questionasked.setText(question2);
                break;

            case 3:
                questionasked.setText(question3);
                break;

            case 4:
                questionasked.setText(question4);
                break;

            case 5:
                questionasked.setText(question5);
                break;

            case 6:
                questionasked.setText(question6);
                break;


            default:
                questionasked.setText("");
                break;

        }
    }
}












