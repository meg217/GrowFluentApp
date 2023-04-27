package edu.utsa.cs3443.growfluent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs3443.growfluent.Controller.MainController;
import edu.utsa.cs3443.growfluent.Model.User;

//import edu.utsa.cs3443.growfluent.growfluent.MainController;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        User user = null;
        //find any intent extras that return from lessons
        int lessonNum = intent.getIntExtra("lessonNum", 0);
        int allCorrect =  3; //max questions
        int numCorrect = intent.getIntExtra("numCorrect", 0);
        //int lessonComplete = intent.getIntExtra("lessonComplete", 0);

        //create user (if necessary)
        user = new User(lessonNum, numCorrect, allCorrect);

        MainController mainController = new MainController(this, lessonNum, allCorrect, numCorrect, user);

        Button GardenButton = findViewById(R.id.Garden_button);
        Button LessonsButton = findViewById(R.id.Lessons_button);
        Button CommunityButton = findViewById(R.id.Community_button);
        Button SettingsButton = findViewById(R.id.Settings_button);

        GardenButton.setOnClickListener(mainController);
        LessonsButton.setOnClickListener(mainController);
        CommunityButton.setOnClickListener(mainController);
        SettingsButton.setOnClickListener(mainController);
    }
}







/*
        button = (Button) findViewById(R.id.Lessons_button);
        button.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                launchLessonsActivity();
           }
        });
        button = (Button) findViewById(R.id.Garden_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchGardenActivity();
            }
        });
    }

    private void launchLessonsActivity() {
        Intent intent = new Intent(this, LessonsActivity.class);
        startActivity(intent);
    }

    private void launchGardenActivity() {
        Intent intent = new Intent(this, GardenActivity.class);
       startActivity(intent);
     }

}*/