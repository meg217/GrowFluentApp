package edu.utsa.cs3443.growfluent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.utsa.cs3443.growfluent.Controller.LessonPassController;

public class LessonPassActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lesson_pass);
            Intent intent = getIntent();
            int lessonNum = intent.getIntExtra("lessonNum", 0);
            int lessonComplete = intent.getIntExtra("lessonComplete", 0);
            int totalQuestions = 3;
            LessonPassController LPController = new LessonPassController(this, totalQuestions, lessonNum);
            Button Back = findViewById(R.id.Back);
            Back.setOnClickListener(LPController);

        }
    }
