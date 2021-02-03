package com.example.android.cryptocurrencyquizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * totalScore will track the total score of the quiz.
     */
    int totalScore = 10;

    /*
     * Functions that tell whether the answers are correct or not.
     */
    private void evaluateAnswer1(String answer1) {
        if (answer1.equals(getString(R.string.trueAnswer1a)) || answer1.equals(getString(R.string.trueAnswer1b))) {
            totalScore += 1;
        }
    }

    private void evaluateAnswer2(boolean answer2a, boolean answer2b, boolean answer2c) {
        if (!answer2a && !answer2b && answer2c) {
            totalScore += 1;
        }
    }

    private void evaluateAnswer3(String answer3) {
        if (answer3.equals(getString(R.string.trueAnswer3))) {
            totalScore += 1;
        }
    }

    private void evaluateAnswer4(boolean answer4yes, boolean answer4no) {
        if (answer4yes && !answer4no) {
            totalScore += 1;
        }
    }

    private void evaluateAnswer5(boolean answer5a, boolean answer5b, boolean answer5c) {
        if (answer5a && !answer5b && answer5c) {
            totalScore += 1;
        }
    }

    /*
     * finalValue reads the values from the front end and evaluate all answers.
     * After that, it constructs string for the final output on the Toast message window.
     */
    public void finalValue(View view) {
        String answer1Value = ((TextView) findViewById(R.id.check_answer_1)).getText().toString();
        boolean answer2AValue = ((RadioButton) findViewById(R.id.check_answer_2a)).isChecked();
        boolean answer2BValue = ((RadioButton) findViewById(R.id.check_answer_2b)).isChecked();
        boolean answer2CValue = ((RadioButton) findViewById(R.id.check_answer_2c)).isChecked();
        String answer3Value = ((TextView) findViewById(R.id.check_answer_3)).getText().toString();
        boolean answer4ValueYes = ((RadioButton) findViewById(R.id.check_answer_4_yes)).isChecked();
        boolean answer4ValueNo = ((RadioButton) findViewById(R.id.check_answer_4_no)).isChecked();
        boolean answer5AValue = ((CheckBox) findViewById(R.id.check_answer_5a)).isChecked();
        boolean answer5BValue = ((CheckBox) findViewById(R.id.check_answer_5b)).isChecked();
        boolean answer5CValue = ((CheckBox) findViewById(R.id.check_answer_5c)).isChecked();

        evaluateAnswer1(answer1Value);
        evaluateAnswer2(answer2AValue, answer2BValue, answer2CValue);
        evaluateAnswer3(answer3Value);
        evaluateAnswer4(answer4ValueYes, answer4ValueNo);
        evaluateAnswer5(answer5AValue, answer5BValue, answer5CValue);

        String textForToast1 = getString(R.string.textForToast1a) + totalScore + getString(R.string.textForToast1b);
        String textForToast2 = "";

        if (totalScore == 0) {
            textForToast2 += getString(R.string.textForToast20);
        } else if (totalScore == 1) {
            textForToast2 += getString(R.string.textForToast21);
        } else if (totalScore == 2 || totalScore == 3 || totalScore == 4) {
            textForToast2 += getString(R.string.textForToast22);
        } else {
            textForToast2 += getString(R.string.textForToast25);
        }

        String textForToastFinal = textForToast1 + textForToast2;

        Toast.makeText(
                getApplicationContext(),
                textForToastFinal,
                Toast.LENGTH_SHORT
        ).show();

        totalScore = 0;
    }
}