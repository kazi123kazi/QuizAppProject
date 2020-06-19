package com.example.quizappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctAnswer=0;
    Button submit,go;
    LinearLayout mLinearLayout;
    ScrollView mScroolView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go=(Button)findViewById(R.id.go);
        submit=(Button)findViewById(R.id.submit);

        mLinearLayout=findViewById(R.id.starting);
        mScroolView=findViewById(R.id.nextLayout);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayout.setVisibility(View.INVISIBLE);
                mScroolView.setVisibility(View.VISIBLE);
            }
        });

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
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
    }

    private void question1() {

        RadioButton ansOne = (RadioButton) findViewById(R.id.q1RadioButton1);
        boolean isa1 = ansOne.isChecked();

        if(isa1) {
            correctAnswer++;
        }  else {
            correctAnswer+=0;
        }
    }

    private void question2() {

        RadioButton ansTwo = (RadioButton) findViewById(R.id.q2RadioButton2);
        boolean isa2 = ansTwo.isChecked();

        if(isa2) {
            correctAnswer++;
        }  else {
            correctAnswer+=0;
        }
    }

    private void question3() {
        CheckBox oxygenChk = (CheckBox) findViewById(R.id.q3CheckBox1);
        boolean isOxygenChk = oxygenChk.isChecked();

        CheckBox hydrogenChk = (CheckBox) findViewById(R.id.q3CheckBox2);
        boolean isHydrogen= hydrogenChk.isChecked();

        CheckBox heliumChk = (CheckBox) findViewById(R.id.q3CheckBox3);
        boolean isHelium = heliumChk.isChecked();

        if(isHydrogen && isOxygenChk && !isHelium) {
            correctAnswer++;
        } else {
            correctAnswer+=0;
        }
    }

    private void question4() {
        CheckBox msDhoni = (CheckBox) findViewById(R.id.q4CheckBox1);
        boolean isMsDhoni = msDhoni.isChecked();

        CheckBox watson = (CheckBox) findViewById(R.id.q4CheckBox3);
        boolean isWatson= watson.isChecked();

        CheckBox salmanKhanChk = (CheckBox) findViewById(R.id.q4CheckBox2);
        boolean isSalmanKhan = salmanKhanChk.isChecked();

        if(isWatson && isMsDhoni && !isSalmanKhan) {
            correctAnswer++;
        }  else {
            correctAnswer+=0;
        }
    }

    private void question5() {
        String worldwr2=getQuestion5Text();

        if(worldwr2.equals("1932")) {
            correctAnswer++;
        } else {
            correctAnswer+=0;
        }
    }

    private String getQuestion5Text() {
        EditText editText2 = findViewById(R.id.q5EditText);
        return editText2.getText().toString();
    }

    private void question6() {
        String founder=getQuestion6Text();

        if(founder.equals("Jeff Bezos")){
            correctAnswer++;
        }
        else {
            correctAnswer+=0;
        }
    }

    private String getQuestion6Text() {
        EditText editText1 = findViewById(R.id.q6EditText);
        return editText1.getText().toString();
    }

    private void resetscore(){
        correctAnswer=0;
    }
}