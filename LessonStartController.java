package edu.utsa.cs3443.growfluent.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.io.IOException;

import edu.utsa.cs3443.growfluent.LessonQuizActivity;
import edu.utsa.cs3443.growfluent.LessonStartActivity;
import edu.utsa.cs3443.growfluent.LessonsActivity;
import edu.utsa.cs3443.growfluent.Model.Lesson;
import edu.utsa.cs3443.growfluent.Model.Module;
import edu.utsa.cs3443.growfluent.R;

public class LessonStartController implements View.OnClickListener{
    private LessonStartActivity startActivity;
    private Module moduleN;
    private Lesson lesson;
    private Context context;
    private String lessonInfo;
    private int lessonNum;

    public LessonStartController(LessonStartActivity activity, String lessonInfo, int lessonNum){
        this.startActivity = activity;
        this.moduleN = new Module();
        this.lessonInfo = lessonInfo;
        this.lessonNum = lessonNum;
    }

    public void onClick(View view){
        this.context = view.getContext();

//        try{
//            moduleN.loadLesson(context, "Lesson1.csv");
//        }
//        catch (IOException e){
//            throw new RuntimeException(e);
//        }

        if(view.getId() == R.id.Back){
            Intent intent = new Intent(startActivity, LessonsActivity.class);
            startActivity.startActivity(intent);
        }

        if(view.getId() == R.id.StartQuiz){
            Intent intent = new Intent(startActivity, LessonQuizActivity.class);
            intent.putExtra("lessonInfo", lessonInfo);
            intent.putExtra("lessonNum", lessonNum);
            startActivity.startActivity(intent);

        }
    }
}