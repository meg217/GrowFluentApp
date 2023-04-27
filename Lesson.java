package edu.utsa.cs3443.growfluent.Model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Lesson extends AppCompatActivity {
    private int lessonNum;
    private int numQuestions;
    private String englishW;
    private String spanishW;

    private int currentQuestions;
    private int correctAnswers;
    //private ArrayList<Lesson> lessons = new ArrayList<Lesson>();
    private ArrayList<Question> questions = new ArrayList<Question>();

    public Lesson(int lessonNum, int numQuestions, String englishW, String spanishW) {
        this.lessonNum = lessonNum;
        this.englishW = englishW;
        this.spanishW = spanishW;
        this.numQuestions = numQuestions;
    }

    public int getLessonNum() {
        return lessonNum;
    }

    public String getEnglishW() {
        return englishW;
    }

    public String getSpanishW(int i) {
        String[] spanishWordsSplit = spanishW.split(",");
        return spanishWordsSplit[i];
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setLessonNum(int lessonNum) {
        this.lessonNum = lessonNum;
    }

    public void setEnglishW(String englishW) {
        this.englishW = englishW;
    }

    public void setSpanishW(String spanishW) {
        this.spanishW = spanishW;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }


    public void addQuestionToLesson(Question question) {
        questions.add(question);
    }

    public String toString() {
        String lessonInfo = englishW + "," + spanishW + "\n";
        return lessonInfo;
    }


    public boolean correctAnswer(String Answer) {

        int i = 0;
        String[] englishWordsSplit = englishW.split(",");
        String[] spanishWordsSplit = spanishW.split(",");

        for (i = 0; i < englishWordsSplit.length; i++) {
            if (Answer.equals(englishWordsSplit[i])) {
                String spanishWord = getSpanishW(i);
                if (spanishWord.equals(spanishWordsSplit[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
//    private void OnCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lessons);
//        Intent intent = getIntent();
//        lessonNumber = intent.getIntExtra("lessonNumber", 0);
//
//        currentQuestions = 0;
//        correctAnswers = 0;
//
//        Button nextQuestion = findViewById(R.id.NextQuestion_button);
//
//    }





