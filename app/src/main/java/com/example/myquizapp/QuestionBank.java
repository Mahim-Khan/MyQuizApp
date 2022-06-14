package com.example.myquizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
     static List<QuestionList> javaQuestions(){
        List<QuestionList> questionLists = new ArrayList<>();
        // Create object of Questions List class and passaquestions along with options and answer
         QuestionList question_1=new QuestionList("What is the size of int variable?","16 bit","8 bit","32 bit","64 bit","32 bit","");
         QuestionList question_2=new QuestionList("What is the default value of Boolean variable?","true","false","null","not defined","false","");
         QuestionList question_3=new QuestionList("What of the following is the default value of an instance variable?","Depends upon the type of variable","null","0","not assigned","Depends upon the type of variable","");
         QuestionList question_4=new QuestionList("Which is a reserved word in the Java programming language?","method","native","reference","array","native","");
         QuestionList question_5=new QuestionList("Which of the following is NOT a keywords or reserved words in Java?","if","then","goto","while","then","");
         QuestionList question_6=new QuestionList("Which is the valid declarations within an interface definition?","public double method();","public final double method();","static void method(double d1);","protected void method(double d3);","public double method();","");

         //add all questions to list<QuestionList>
        questionLists.add(question_1);
        questionLists.add(question_2);
        questionLists.add(question_3);
        questionLists.add(question_4);
        questionLists.add(question_5);
        questionLists.add(question_6);
        return questionLists;
    }
     static List<QuestionList> phpQuestions(){
        List<QuestionList> questionLists = new ArrayList<>();
        // Create object of Questions List class and passaquestions along with options and answer
        QuestionList question_1=new QuestionList("What does PHP stands for?","Professional Home Page","HyperText Preprocessor","32 bit","Preprocessor Home Page","HyperText Preprocessor","");
        QuestionList question_2=new QuestionList("What is the default value of Boolean variable?","true","false","null","not defined","false","");
        QuestionList question_3=new QuestionList("What of the following is the default value of an instance variable?","Depends upon the type of variable","null","0","not assigned","Depends upon the type of variable","");
        QuestionList question_4=new QuestionList("Which is a reserved word in the Java programming language?","method","native","reference","array","native","");
        QuestionList question_5=new QuestionList("Which of the following is NOT a keywords or reserved words in Java?","if","then","goto","while","then","");
        QuestionList question_6=new QuestionList("Which is the valid declarations within an interface definition?","public double method();","public final double method();","static void method(double d1);","protected void method(double d3);","public double method();","");

        //add all questions to list<QuestionList>
        questionLists.add(question_1);
        questionLists.add(question_2);
        questionLists.add(question_3);
        questionLists.add(question_4);
        questionLists.add(question_5);
        questionLists.add(question_6);
        return questionLists;
    }
     static List<QuestionList> htmlQuestions(){
        List<QuestionList> questionLists = new ArrayList<>();
        // Create object of Questions List class and passaquestions along with options and answer
        QuestionList question_1=new QuestionList("What is the size of int variable?","16 bit","8 bit","32 bit","64 bit","32 bit","");
        QuestionList question_2=new QuestionList("What is the default value of Boolean variable?","true","false","null","not defined","false","");
        QuestionList question_3=new QuestionList("What of the following is the default value of an instance variable?","Depends upon the type of variable","null","0","not assigned","Depends upon the type of variable","");
        QuestionList question_4=new QuestionList("Which is a reserved word in the Java programming language?","method","native","reference","array","native","");
        QuestionList question_5=new QuestionList("Which of the following is NOT a keywords or reserved words in Java?","if","then","goto","while","then","");
        QuestionList question_6=new QuestionList("Which is the valid declarations within an interface definition?","public double method();","public final double method();","static void method(double d1);","protected void method(double d3);","public double method();","");

        //add all questions to list<QuestionList>
        questionLists.add(question_1);
        questionLists.add(question_2);
        questionLists.add(question_3);
        questionLists.add(question_4);
        questionLists.add(question_5);
        questionLists.add(question_6);
        return questionLists;
    }
     static List<QuestionList> androidQuestions(){
        List<QuestionList> questionLists = new ArrayList<>();
        // Create object of Questions List class and passaquestions along with options and answer
        QuestionList question_1=new QuestionList("What is the size of int variable?","16 bit","8 bit","32 bit","64 bit","32 bit","");
        QuestionList question_2=new QuestionList("What is the default value of Boolean variable?","true","false","null","not defined","false","");
        QuestionList question_3=new QuestionList("What of the following is the default value of an instance variable?","Depends upon the type of variable","null","0","not assigned","Depends upon the type of variable","");
        QuestionList question_4=new QuestionList("Which is a reserved word in the Java programming language?","method","native","reference","array","native","");
        QuestionList question_5=new QuestionList("Which of the following is NOT a keywords or reserved words in Java?","if","then","goto","while","then","");
        QuestionList question_6=new QuestionList("Which is the valid declarations within an interface definition?","public double method();","public final double method();","static void method(double d1);","protected void method(double d3);","public double method();","");

        //add all questions to list<QuestionList>
        questionLists.add(question_1);
        questionLists.add(question_2);
        questionLists.add(question_3);
        questionLists.add(question_4);
        questionLists.add(question_5);
        questionLists.add(question_6);
        return questionLists;
    }
     static List<QuestionList> getQuestions(String selectedTopicName){
       switch (selectedTopicName){
           case "java":
               return javaQuestions();
           case "php":
               return javaQuestions();
           case "android":
               return javaQuestions();

           default:
               return htmlQuestions();
       }
    }

}
