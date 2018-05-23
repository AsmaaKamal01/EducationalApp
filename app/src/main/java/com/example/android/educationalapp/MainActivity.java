package com.example.android.educationalapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int resultQuestionOne;
    private int resultQuestionTwo;
    private int resultQuestionThree;
    private int resultQuestionFour;
    private int resultQuestionFive;
    private int resultQuestionSix;
    private int totalResult;

// function for the first question

    public void RadioButtonClickedQuestionOne(View view) {
        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.a_radio_button_question_one:
                if (checked)
                    resultQuestionOne = 1;
                break;
            case R.id.b_radio_button_question_one:
                if (checked)
                    resultQuestionOne = 0;
                    break;
        }
    }

    // function for the second question
    public void RadioButtonClickedQuestionTwo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.a_radio_button_question_two:
                if (checked)
                    resultQuestionTwo = 0;
                    break;
            case R.id.b_radio_button_question_two:
                if (checked)
                    resultQuestionTwo = 1;

                break;
        }
    }

    // function for the third question
    public void RadioButtonClickedQuestionThree(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.a_radio_button_question_three:
                if (checked)
                    resultQuestionThree = 1;

                break;
            case R.id.b_radio_button_question_three:
                if (checked)
                    resultQuestionThree = 0;
                    break;
        }
    }


    // function for question four
    boolean counterQuestionFourA = false;
    boolean counterQuestionFourB = false;

    public void onCheckboxClickedQuestionFour(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_four_a:
                if (checked)
                    counterQuestionFourA = true;
                break;
            case R.id.checkbox_four_b:
                if (checked)
                    counterQuestionFourB = true;

                break;

            case R.id.checkbox_four_c:
                if (checked)
                    counterQuestionFourA = false;
                counterQuestionFourB = false;
                break;
            default:

        }
        if (counterQuestionFourA  && counterQuestionFourB) {
            resultQuestionFour = 1;

        } else {
            resultQuestionFour = 0;
        }
    }

    boolean counterQuestionFiveA = false;
    boolean counterQuestionFiveB = false;

    // function for question five
    public void onCheckboxClickedQuestionFive(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_five_a:
                if (checked)
                    counterQuestionFiveA = true;
                break;
            case R.id.checkbox_five_c:
                if (checked)
                    counterQuestionFiveB = true;

                break;
            case R.id.checkbox_five_b:
                if (checked){
                    counterQuestionFiveA = false;
                counterQuestionFiveB = false;}
                break;
            default:
        }
        if (counterQuestionFiveA  && counterQuestionFiveB ) {
            resultQuestionFive = 1;

        } else {
            resultQuestionFive = 0;
        }
    }

  //  question six:
  boolean resultOfEditText;
  public void QuestionSixEditText(View view) {

      EditText editValue = findViewById(R.id.edit_text);
      // I use trim() to remove any trailing spaces from the user input. It will make the validation perfect.
      String stringEditValue = editValue.getText().toString().trim();
      String inputString = "channel coding";
//I use an equalsIgnoreCase method here. It will handle the answer with uppercase, lowercase, or both of them.
      resultOfEditText = stringEditValue.equalsIgnoreCase(inputString);

      if (resultOfEditText ) {
          resultQuestionSix = 1;
      } else {
          resultQuestionSix = 0;
      }
  }


    // function for submit button
    public void addOne() {
        if (resultQuestionOne == 1) {
            totalResult += 1;
        }
        if (resultQuestionTwo == 1) {
            totalResult += 1;
        }
        if (resultQuestionThree == 1) {
            totalResult += 1;
        }
        if (resultQuestionFour == 1) {
            totalResult += 1;
        }
        if (resultQuestionFive == 1) {
            totalResult += 1;
        }
        if (resultQuestionSix == 1) {
            totalResult += 1;


        }

    }

    public void actionSubmitButton(View view) {

        addOne();
        String report = "Good Job! You Get " + totalResult + " Correct Answers ";
        Toast.makeText(getApplicationContext(), report,
                Toast.LENGTH_SHORT).show();
        totalResult = 0;
    }

}
