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

    /**
     * Define variables for Radiobuttons, EditText, TextView and Checkboxes
     * @param savedInstanceState
     */
    private RadioButton firstRadioButton;
    private RadioButton secondRadioButton;
    private RadioButton thirdRadioButton;
    private EditText editText;
    private CheckBox firstCheckBox;
    private CheckBox secondCheckBox;
    private CheckBox thirdCheckBox;
    private CheckBox fourthCheckBox;
    private CheckBox fifthCheckBox;
    private CheckBox sixthCheckBox;
    private TextView textView;
    private RadioGroup firstRadioGroup;
    private RadioGroup secondRadioGroup;
    private RadioGroup thirdRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstRadioButton = (RadioButton) findViewById(R.id.correct_first_answer);
        secondRadioButton = (RadioButton) findViewById(R.id.correct_second_answer);
        thirdRadioButton = (RadioButton) findViewById(R.id.correct_third_answer);
        editText = (EditText) findViewById(R.id.first_edit_text);
        firstCheckBox = (CheckBox) findViewById(R.id.first_checkbox);
        secondCheckBox = (CheckBox) findViewById(R.id.second_checkbox);
        thirdCheckBox = (CheckBox) findViewById(R.id.third_checkbox);
        fourthCheckBox = (CheckBox) findViewById(R.id.fourth_checkbox);
        fifthCheckBox = (CheckBox) findViewById(R.id.fifth_checkbox);
        sixthCheckBox = (CheckBox) findViewById(R.id.sixth_checkbox);
        textView = (TextView) findViewById(R.id.correct_invisible_text);
        firstRadioGroup = (RadioGroup) findViewById(R.id.first_radio_group);
        secondRadioGroup = (RadioGroup) findViewById(R.id.second_radio_group);
        thirdRadioGroup = (RadioGroup) findViewById(R.id.third_radio_group);
    }

    /**
     * Checks the good answers and counts points. The result is display in toast on the screen
     *
     * @param view
     */
    public void displayResults(View view) {
        int point = 0;

        boolean toCheckOne = firstRadioButton.isChecked();
        if (toCheckOne) {
            point++;
        }
        boolean toCheckTwo = secondRadioButton.isChecked();
        if (toCheckTwo) {
            point++;
        }
        boolean toCheckThree = thirdRadioButton.isChecked();
        if (toCheckThree) {
            point++;
        }

        String toCheckFour = editText.getText().toString();
        String answer = "7";
        if (toCheckFour.equals(answer)) {
            point++;
        }
        boolean toCheckFirstCheckBox = firstCheckBox.isChecked();
        boolean toCheckFourCheckBox = fourthCheckBox.isChecked();
        boolean toCheckSecondCheckBox = secondCheckBox.isChecked();
        boolean toThirdSecondCheckBox = thirdCheckBox.isChecked();
        boolean toCheckSFifthCheckBox = fifthCheckBox.isChecked();
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

        firstRadioGroup.clearCheck();
        secondRadioGroup.clearCheck();
        thirdRadioGroup.clearCheck();
        editText.getText().clear();
        firstCheckBox.setChecked(false);
        secondCheckBox.setChecked(false);
        thirdCheckBox.setChecked(false);
        fourthCheckBox.setChecked(false);
        fifthCheckBox.setChecked(false);
        sixthCheckBox.setChecked(false);
        textView.setVisibility(View.INVISIBLE);
    }

    /**
     * Display all good answers in whole QuizApp. In the first call method resetData to clear all, then select correct data
     *
     * @param view
     */
    public void showGoodAnswers(View view) {
        resetData();
        firstRadioButton.setChecked(true);
        secondRadioButton.setChecked(true);
        thirdRadioButton.setChecked(true);
        editText.setText("7");
        textView.setVisibility(View.VISIBLE);
        firstCheckBox.setChecked(true);
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
