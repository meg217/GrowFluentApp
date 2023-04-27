package edu.utsa.cs3443.growfluent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import edu.utsa.cs3443.growfluent.Controller.LessonController;
import edu.utsa.cs3443.growfluent.Model.Lesson;
import edu.utsa.cs3443.growfluent.Model.Module;

public class LessonsActivity extends AppCompatActivity {
    //private int currentLesson;
    private Context context;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        LessonController lessonController = new LessonController(this);
        Button Lesson1Button = findViewById(R.id.Lesson1_button);
        Button Lesson2Button = findViewById(R.id.Lesson2_button);
        Button Lesson3Button = findViewById(R.id.Lesson3_button);

        Lesson1Button.setOnClickListener(lessonController);
        Lesson2Button.setOnClickListener(lessonController);
        Lesson3Button.setOnClickListener(lessonController);
    }
}
