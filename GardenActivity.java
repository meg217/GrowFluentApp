package edu.utsa.cs3443.growfluent;
import static java.util.logging.Logger.global;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import edu.utsa.cs3443.growfluent.Controller.GardenController;
import edu.utsa.cs3443.growfluent.Model.Garden;
import edu.utsa.cs3443.growfluent.Model.Lesson;
import edu.utsa.cs3443.growfluent.Model.Module;
import edu.utsa.cs3443.growfluent.R;

public class GardenActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "GardenActivityPrefs";
    private static final String KEY_LESSON1_HIGHEST = "lesson1Highest";
    private boolean lesson1Highest = false;
    private static final String KEY_LESSON2_HIGHEST = "lesson2Highest";
    private boolean lesson2Highest = false;
    private static final String KEY_LESSON3_HIGHEST = "lesson3Highest";
    private boolean lesson3Highest = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);
        Intent intent = getIntent();
        int numCorrect1 = intent.getIntExtra("numCorrect1", 0);
        int numCorrect2 = intent.getIntExtra("numCorrect2", 0);
        int numCorrect3 = intent.getIntExtra("numCorrect3", 0);
        int allCorrect = intent.getIntExtra("allCorrect", 0);
        int lessonNum = intent.getIntExtra("lessonNum", 0);
        //int lessonComplete = intent.getIntExtra("lessonComplete", 0);

        Garden newGarden = new Garden(lessonNum, numCorrect1, numCorrect2, numCorrect3, allCorrect);
        GardenController GC = new GardenController(this, newGarden);
        Button Back = findViewById(R.id.Back_garden);
        Back.setOnClickListener(GC);

        ImageView Plant1 = findViewById(R.id.Plant1);
        Plant1.setLayoutParams(new ViewGroup.LayoutParams(350, 350));
        Plant1.setX(100);
        Plant1.setY(100);
        TextView progress1 = findViewById(R.id.Progress1);
        progress1.setText(numCorrect1 + "/" + allCorrect);

        ImageView Plant2 = findViewById(R.id.Plant2);
        Plant2.setLayoutParams(new ViewGroup.LayoutParams(350, 350));
        Plant2.setX(100);
        Plant2.setY(650);
        TextView progress2 = findViewById(R.id.Progress2);
        progress2.setText(numCorrect2 + "/" + allCorrect);

        ImageView Plant3 = findViewById(R.id.Plant3);
        Plant3.setLayoutParams(new ViewGroup.LayoutParams(350, 350));
        Plant3.setX(100);
        Plant3.setY(1200);
        TextView progress3 = findViewById(R.id.Progress3);
        progress3.setText(numCorrect3 + "/" + allCorrect);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        lesson1Highest = prefs.getBoolean(KEY_LESSON1_HIGHEST, false);
        lesson2Highest = prefs.getBoolean(KEY_LESSON2_HIGHEST, false);
        lesson3Highest = prefs.getBoolean(KEY_LESSON3_HIGHEST, false);



        if(!prefs.contains(KEY_LESSON1_HIGHEST)){
            saveLesson1Highest();
        }


        if(!prefs.contains(KEY_LESSON2_HIGHEST)){
            saveLesson2Highest();
        }

        if(!prefs.contains(KEY_LESSON3_HIGHEST)){
            saveLesson3Highest();
        }

        //    Plant 1 Picture
        //Plant 1 Picture
        if (lesson1Highest == false) {
            switch (newGarden.lessonProgress[0][0]) {
                case 1:
                case 2:
                    Plant1.setImageResource(R.drawable.lessonsprout);
                    break;
                case 3:
                    Plant1.setImageResource(R.drawable.lesson1flower);
                    lesson1Highest = true;
                    saveLesson1Highest();
                    break;
                default:
                    Plant1.setImageResource(R.drawable.lessonsprout);
            }
        } else {
            Plant1.setImageResource(R.drawable.lesson1flower);
            progress1.setText("3/3");
        }

//Plant 2 Picture
        if (lesson2Highest == false) {
            switch (newGarden.lessonProgress[1][0]) {
                case 1:
                case 2:
                    Plant2.setImageResource(R.drawable.lessonsprout);
                    break;
                case 3:
                    Plant2.setImageResource(R.drawable.lesson2flower);
                    lesson2Highest = true;
                    saveLesson2Highest();
                    break;
                default:
                    Plant2.setImageResource(R.drawable.lessonsprout);
            }
        } else {
            Plant2.setImageResource(R.drawable.lesson2flower);
            progress2.setText("3/3");
        }

//Plant 3 Picture
        if (lesson3Highest == false) {
            switch (newGarden.lessonProgress[2][0]) {
                case 1:
                case 2:
                    Plant3.setImageResource(R.drawable.lessonsprout);
                    break;
                case 3:
                    Plant3.setImageResource(R.drawable.lesson3flower);
                    lesson3Highest = true;
                    saveLesson3Highest();
                    break;
                default:
                    Plant3.setImageResource(R.drawable.lessonsprout);
            }
        } else {
            Plant3.setImageResource(R.drawable.lesson3flower);
            progress3.setText("3/3");
        }
    }
        private void saveLesson1Highest() {
            SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(KEY_LESSON1_HIGHEST, lesson1Highest);
            editor.apply();
        }

    private void saveLesson2Highest() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_LESSON2_HIGHEST, lesson2Highest);
        editor.apply();
    }

    private void saveLesson3Highest() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_LESSON3_HIGHEST, lesson3Highest);
        editor.apply();
    }

    }
