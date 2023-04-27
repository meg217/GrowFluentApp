package edu.utsa.cs3443.growfluent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.utsa.cs3443.growfluent.Controller.LessonFailController;

public class LessonFailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_fail);
        Intent intent = getIntent();
        int numCorrect = intent.getIntExtra("numCorrect", 0);
        int lessonNum = intent.getIntExtra("lessonNum", 0);
        TextView textView = findViewById(R.id.textViewFail);

        textView.setText("Fail:" + numCorrect + "/3!");

        LessonFailController LFController = new LessonFailController(this, numCorrect, lessonNum);
        Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(LFController);

    }
}