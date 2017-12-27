package xyz.marcindobienko.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Made by Marcin Dobienko
 *
 * Quiz of Geography, check basic knowledge. App can checks correct answers and display points.
 * It can display correct answers when button "show good answers" is pressed.
 * Button "RESET" clear all answers. Enjoy.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Checks the good answers and counts points. The result is display in toast on the screen
     *
     * @param view
     */
    public void displayResults(View view) {
        int point = 0;

        RadioButton firstRadioButton = (RadioButton) findViewById(R.id.correct_first_answer);
        boolean toCheckOne = firstRadioButton.isChecked();
        if (toCheckOne) {
            point++;
        }
        RadioButton secondRadioButton = (RadioButton) findViewById(R.id.correct_second_answer);
        boolean toCheckTwo = secondRadioButton.isChecked();
        if (toCheckTwo) {
            point++;
        }
        RadioButton thirdRadioButton = (RadioButton) findViewById(R.id.correct_third_answer);
        boolean toCheckThree = thirdRadioButton.isChecked();
        if (toCheckThree) {
            point++;
        }
        EditText editText = (EditText) findViewById(R.id.first_edit_text);
        String toCheckFour = editText.getText().toString();
        String answer = "7";
        if (toCheckFour.equals(answer)) {
            point++;
        }
        CheckBox firstCheckBox = (CheckBox) findViewById(R.id.first_checkbox);
        boolean toCheckFirstCheckBox = firstCheckBox.isChecked();
        CheckBox fourthCheckBox = (CheckBox) findViewById(R.id.fourth_checkbox);
        boolean toCheckFourCheckBox = fourthCheckBox.isChecked();
        CheckBox secondCheckBox = (CheckBox) findViewById(R.id.second_checkbox);
        boolean toCheckSecondCheckBox = secondCheckBox.isChecked();
        CheckBox thirdCheckBox = (CheckBox) findViewById(R.id.third_checkbox);
        boolean toThirdSecondCheckBox = thirdCheckBox.isChecked();
        CheckBox fifthCheckBox = (CheckBox) findViewById(R.id.fifth_checkbox);
        boolean toCheckSFifthCheckBox = fifthCheckBox.isChecked();
        CheckBox sixthCheckBox = (CheckBox) findViewById(R.id.sixth_checkbox);
        boolean toCheckSixthCheckBox = sixthCheckBox.isChecked();
        if ((toCheckFirstCheckBox && toCheckFourCheckBox) &&
                (toCheckSecondCheckBox==false && toThirdSecondCheckBox==false && toCheckSFifthCheckBox==false && toCheckSixthCheckBox==false)) {
            point++;
        }

        Toast.makeText(this, "You get " + point + " on 5", Toast.LENGTH_LONG).show();

    }

    /**
     * Reset all introduced data, checked boxes and radioGroups in QuizApp
     */
    public void resetData() {
        RadioGroup firstRadioGroup = (RadioGroup) findViewById(R.id.first_radio_group);
        firstRadioGroup.clearCheck();
        RadioGroup secondRadioGroup = (RadioGroup) findViewById(R.id.second_radio_group);
        secondRadioGroup.clearCheck();
        RadioGroup thirdRadioGroup = (RadioGroup) findViewById(R.id.third_radio_group);
        thirdRadioGroup.clearCheck();
        EditText editText = (EditText) findViewById(R.id.first_edit_text);
        editText.getText().clear();
        CheckBox firstCheckBox = (CheckBox) findViewById(R.id.first_checkbox);
        firstCheckBox.setChecked(false);
        CheckBox secondCheckBox = (CheckBox) findViewById(R.id.second_checkbox);
        secondCheckBox.setChecked(false);
        CheckBox thirdCheckBox = (CheckBox) findViewById(R.id.third_checkbox);
        thirdCheckBox.setChecked(false);
        CheckBox fourthCheckBox = (CheckBox) findViewById(R.id.fourth_checkbox);
        fourthCheckBox.setChecked(false);
        CheckBox fifthCheckBox = (CheckBox) findViewById(R.id.fifth_checkbox);
        fifthCheckBox.setChecked(false);
        CheckBox sixthCheckBox = (CheckBox) findViewById(R.id.sixth_checkbox);
        sixthCheckBox.setChecked(false);
        TextView textView = (TextView) findViewById(R.id.correct_invisible_text);
        textView.setVisibility(View.INVISIBLE);
    }

    /**
     * Display all good answers in whole QuizApp. In the first call method resetData to clear all, then select correct data
     *
     * @param view
     */
    public void showGoodAnswers(View view) {
        resetData();
        RadioButton firstRadionButton = (RadioButton) findViewById(R.id.correct_first_answer);
        firstRadionButton.setChecked(true);
        RadioButton secondRadionButton = (RadioButton) findViewById(R.id.correct_second_answer);
        secondRadionButton.setChecked(true);
        RadioButton thirdRadionButton = (RadioButton) findViewById(R.id.correct_third_answer);
        thirdRadionButton.setChecked(true);
        EditText editText = (EditText) findViewById(R.id.first_edit_text);
        editText.setText("7");
        TextView textView = (TextView) findViewById(R.id.correct_invisible_text);
        textView.setVisibility(View.VISIBLE);
        CheckBox firstCheckBox = (CheckBox) findViewById(R.id.first_checkbox);
        firstCheckBox.setChecked(true);
        CheckBox fourthCheckBox = (CheckBox) findViewById(R.id.fourth_checkbox);
        fourthCheckBox.setChecked(true);
    }

    /**
     * Call resetData method when RESET button is pressed
     *
     * @param view
     */
    public void resetButton(View view) {
        resetData();
    }
}
