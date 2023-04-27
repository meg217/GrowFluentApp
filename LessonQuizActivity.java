package edu.utsa.cs3443.growfluent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.utsa.cs3443.growfluent.Controller.LessonQuizController;
import edu.utsa.cs3443.growfluent.Controller.LessonStartController;

public class LessonQuizActivity extends AppCompatActivity {
    //private LessonQuizController quizController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_quiz);
        Intent intent = getIntent();
        int lessonNum = intent.getIntExtra("lessonNum", 0);
        String lessonInfo = intent.getStringExtra("lessonInfo");


        //        intent.putExtra("lessonInfo", lessonInfo);
//        intent.putExtra("lessonNum", lessonNum);

        String[] parseInfo = lessonInfo.split(",");
        String q1= "";
        String q2="";
        String q3="";
        TextView textView1;
        TextView textView2;
        TextView textView3;
        EditText editText1;
        EditText editText2;
        EditText editText3;


        textView1 = findViewById(R.id.Q1Spanish);
        editText1 = findViewById(R.id.Q1English);

        textView2 = findViewById(R.id.Q2Spanish);
        editText2 = findViewById(R.id.Q2English);

        textView3 = findViewById(R.id.Q3Spanish);
        editText3 = findViewById(R.id.Q3English);


        textView1.setText(parseInfo[4]);
        //q1 = editText1.getText().toString();

        textView2.setText(parseInfo[5]);
        // q2 = editText2.getText().toString();

        textView3.setText(parseInfo[6]);
        //q3 = editText3.getText().toString();


        LessonQuizController lessonQuizController = new LessonQuizController(this, lessonNum, lessonInfo);

        Button SubmitQuiz = findViewById(R.id.SubmitQuiz);
        SubmitQuiz.setOnClickListener(lessonQuizController);
    }

}