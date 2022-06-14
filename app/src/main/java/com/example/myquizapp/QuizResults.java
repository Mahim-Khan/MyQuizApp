package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {
    AppCompatButton startNewBtn;
    TextView correctAnswer,inCorrectAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        startNewBtn = findViewById(R.id.startNewQuizBtn);
        correctAnswer = findViewById(R.id.correctAnswer);
        inCorrectAnswer = findViewById(R.id.inCorrectAnswer);
        int getCorrectAnswers = getIntent().getIntExtra("correct",0);
        int getInCorrectAnswers = getIntent().getIntExtra("incorrect",0);
        correctAnswer.setText(String.valueOf("Correct Answer : "+getCorrectAnswers));
        inCorrectAnswer.setText(String.valueOf("Incorrect Answer : "+getInCorrectAnswers));
        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResults.this,MainActivity.class));
        finish();
    }
}