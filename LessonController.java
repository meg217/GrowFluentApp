package edu.utsa.cs3443.growfluent.Controller;

import android.view.View;
import android.content.Context;
import android.content.Intent;
import java.io.IOException;

import edu.utsa.cs3443.growfluent.LessonStartActivity;
import edu.utsa.cs3443.growfluent.LessonsActivity;
import edu.utsa.cs3443.growfluent.Model.Lesson;
import edu.utsa.cs3443.growfluent.Model.Module;
import edu.utsa.cs3443.growfluent.R;

public class LessonController implements View.OnClickListener{

    private LessonsActivity lessonActivity;
    private Module moduleN;
    private Lesson lesson;
    private Context context;
    private String lessonInfo;
    private int lessonNum;


    public LessonController(LessonsActivity lessonsActivity){
        this.lessonActivity = lessonsActivity;
        this.moduleN = new Module();
    }

    public void onClick(View view) {
        context = view.getContext();


        if(view.getId() == R.id.Lesson1_button) {
            try {
                moduleN.loadLesson(context, "Lesson1.csv");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            lesson = moduleN.getLesson(1);
            lessonInfo = lesson.toString();
            lessonNum = 1;
        }

        if(view.getId() == R.id.Lesson2_button) {
            try {
                moduleN.loadLesson(context, "Lesson2.csv");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            lesson = moduleN.getLesson(2);
            lessonInfo = lesson.toString();
            lessonNum = 2;
        }

        if(view.getId() == R.id.Lesson3_button) {
            try {
                moduleN.loadLesson(context, "Lesson3.csv");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            lesson = moduleN.getLesson(3);
            lessonInfo = lesson.toString();
            lessonNum = 3;
        }

        Intent intent = new Intent(lessonActivity, LessonStartActivity.class);
        intent.putExtra("lessonNum", lessonNum);
        intent.putExtra("lessonInfo", lessonInfo);

        lessonActivity.startActivity(intent);

    }

}