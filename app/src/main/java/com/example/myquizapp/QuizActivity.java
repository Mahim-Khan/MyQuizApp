package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {
    TextView questions,question;
    ImageView backBtn ;
    Timer quizTimer;
    int totalTimeInMin =1;
    private List<QuestionList> questionLists ;
    int seconds =0;
    TextView timer,selectedTopicName;
    AppCompatButton option1,option2,option3,option4,nextBtn;
    int currentQuestionPosition =0;
    String selectedOptionByUser ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        backBtn = findViewById(R.id.backBtn);
        question = findViewById(R.id.question);
        questions = findViewById(R.id.questions);
        timer = findViewById(R.id.timer);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);
        selectedTopicName = findViewById(R.id.topicName);
       //============================================================//
        String getSelectedTopicName= getIntent()
                .getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);
        questionLists = QuestionBank.getQuestions(getSelectedTopicName);
        startTimer(timer);
        questions.setText((currentQuestionPosition +1)+"/"+questionLists.size());
        question.setText(questionLists.get(0).getQuestion());
        option1.setText(questionLists.get(0).getOption1());
        option2.setText(questionLists.get(0).getOption2());
        option3.setText(questionLists.get(0).getOption3());
        option4.setText(questionLists.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionLists.get(currentQuestionPosition)
                            .setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionLists.get(currentQuestionPosition)
                            .setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionLists.get(currentQuestionPosition)
                            .setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();
                startActivity(new Intent(QuizActivity.this,MainActivity.class));
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                }else {
                    changeNextQuestion();
                }
            }
        });
      //============================================================//

    }
    //============================================================//
    private void changeNextQuestion(){
        currentQuestionPosition++;
        if ((currentQuestionPosition+1)== questionLists.size()){
            nextBtn.setText("Submit Quiz");
        }
        if (currentQuestionPosition<questionLists.size()){
            selectedOptionByUser ="";
            option1.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option1.setTextColor(Color.parseColor("#1F6888"));

            option2.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option2.setTextColor(Color.parseColor("#1F6888"));

            option3.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option3.setTextColor(Color.parseColor("#1F6888"));

            option4.setBackgroundResource(R.drawable.round_back_white_stoke2_10);
            option4.setTextColor(Color.parseColor("#1F6888"));

            questions.setText((currentQuestionPosition +1)+"/"+questionLists.size());
            question.setText(questionLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionLists.get(currentQuestionPosition).getOption4());

        }
        else {
            Intent intent = new Intent(QuizActivity.this,QuizResults.class);
            intent.putExtra("correct",getCorrectAnswer());
            intent.putExtra("incorrect",getInCorrectAnswer());
            startActivity(intent);
            finish();
        }
    }
    //============================================================//
    //============================================================//
    private  void startTimer(TextView timerTextView){
        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds==0){
                    totalTimeInMin--;
                    seconds = 59;
                }
                else if(seconds == 0 && totalTimeInMin ==0){
                    quizTimer.purge();
                    quizTimer.cancel();
                    Toast.makeText(QuizActivity.this, "Time Over", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizActivity.this,QuizResults.class);
                    intent.putExtra("correct",getCorrectAnswer());
                    intent.putExtra("incorrect",getInCorrectAnswer());
                    startActivity(intent);
                    finish();
                }
                else {
                    seconds--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String
                                .valueOf(totalTimeInMin);
                        String finalSeconds = String.valueOf(seconds);
                        if (finalMinutes.length()==1){
                            finalMinutes ="0"+finalMinutes;
                        }
                        if (finalSeconds.length()==1){
                            finalSeconds ="0"+finalSeconds;
                        }
                        timerTextView.setText(finalMinutes+":"+finalSeconds);
                    }
                });
            }
        }, 1000,1000);
    }
    //============================================================//
    //============================================================//
    private int getCorrectAnswer(){
        int correctAnswer =0;
        for (int i =0;i<questionLists.size();i++){
            String getUserSelectedAnswer = questionLists
                    .get(i).getUserSelectedAnswer();
            String getAnswer = questionLists.get(i).getAnswer();
            if (getUserSelectedAnswer.equals(getAnswer)){
                correctAnswer++;
            }
        }
        return correctAnswer;
    }
    //============================================================//
    private int getInCorrectAnswer(){
        int correctAnswer =0;
        for (int i =0;i<questionLists.size();i++){
            String getUserSelectedAnswer = questionLists
                    .get(i).getUserSelectedAnswer();
            String getAnswer = questionLists.get(i).getAnswer();
            if (!getUserSelectedAnswer.equals(getAnswer)){
                correctAnswer++;
            }
        }
        return correctAnswer;
    }
    //============================================================//

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();
        startActivity(new Intent(QuizActivity.this,MainActivity.class));
        finish();
    }
    private void revealAnswer(){
        String getAnswer = questionLists.get(currentQuestionPosition).getAnswer();
        if (option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green10);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green10);
            option2.setTextColor(Color.WHITE);

        }
        else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green10);
            option3.setTextColor(Color.WHITE);

        }
        else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green10);
            option4.setTextColor(Color.WHITE);

        }
    }
}