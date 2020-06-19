package com.example.quizappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int correctAnswer=0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialising widget

        initwidget();
         
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateAllquestionAnswer();
                Toast.makeText(MainActivity.this , "Your final Score is "+correctAnswer , Toast.LENGTH_LONG).show();
                resetscore();
            }
        });



    }

    private void CalculateAllquestionAnswer() {
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
    }
    private void Question1() {

        RadioButton ansOne = (RadioButton) findViewById(R.id.q1RadioButton1);
        boolean isa1 = ansOne.isChecked();

        if(isa1) {
            correctAnswer++;
        }
    }

    private void Question2() {

        RadioButton ansTwo = (RadioButton) findViewById(R.id.q2RadioButton2);
        boolean isa2 = ansTwo.isChecked();

        if(isa2) {
            correctAnswer++;
        }
    }
    private void Question3() {
        CheckBox oxygenChk = (CheckBox) findViewById(R.id.q3CheckBox1);
        boolean isoxygenChk = oxygenChk.isChecked();

        CheckBox hydrogenChk = (CheckBox) findViewById(R.id.q3CheckBox2);
        boolean ishydrogen= hydrogenChk.isChecked();

        if(ishydrogen && isoxygenChk) {
            correctAnswer++;
        }
    }
    private void Question4() {
        CheckBox msDhoni = (CheckBox) findViewById(R.id.q4CheckBox1);
        boolean ismsDhoni = msDhoni.isChecked();

        CheckBox watson = (CheckBox) findViewById(R.id.q4CheckBox3);
        boolean isWatson= watson.isChecked();

        if(isWatson&& ismsDhoni) {
            correctAnswer++;
        }
    }
    private void Question5() {
        String worldwr2=getQuestion5Text();

        if(worldwr2.equals("1932")) {
            correctAnswer++;
        }
    }

    private String getQuestion5Text() {
        EditText editText2 = findViewById(R.id.q5EditText);
        return editText2.getText().toString();

    }

    private void Question6() {
        String founder=getQuestion6Text();

        if(founder.equals("Jeff Bezos")){
            correctAnswer++;
        }
    }

    private String getQuestion6Text() {
        EditText editText1 = findViewById(R.id.q6EditText);
        return editText1.getText().toString();
    }

    private void initwidget() {

       submit=(Button)findViewById(R.id.submit);
    }

    private void resetscore(){
        correctAnswer=0;
    }
}