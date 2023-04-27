package edu.utsa.cs3443.growfluent.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.utsa.cs3443.growfluent.LessonFailActivity;
import edu.utsa.cs3443.growfluent.LessonPassActivity;
import edu.utsa.cs3443.growfluent.MainActivity;
import edu.utsa.cs3443.growfluent.R;

public class LessonPassController implements View.OnClickListener{
    private LessonPassActivity LessonPassActivity;
    private Context context;
    private int numCorrect;
    private int lessonNum;
    //private int lessonComplete;

    public LessonPassController(LessonPassActivity LessonPassActivity, int allCorrect, int lessonNum){
        this.LessonPassActivity = LessonPassActivity;
        this.numCorrect = allCorrect;
        this.lessonNum = lessonNum;
        //this.lessonComplete = lessonComplete;
    }
    public void onClick(View view) {
        context = view.getContext();

        if (view.getId() == R.id.Back) {
            Intent intent = new Intent(LessonPassActivity, MainActivity.class);
            intent.putExtra("numCorrect", numCorrect);
            intent.putExtra("lessonNum", lessonNum);
            //intent.putExtra("lessonComplete", lessonComplete);
            LessonPassActivity.startActivity(intent);
        }
    }
}