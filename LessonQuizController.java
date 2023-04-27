package edu.utsa.cs3443.growfluent.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import edu.utsa.cs3443.growfluent.LessonFailActivity;
import edu.utsa.cs3443.growfluent.LessonPassActivity;
import edu.utsa.cs3443.growfluent.LessonQuizActivity;
import edu.utsa.cs3443.growfluent.Model.Lesson;
import edu.utsa.cs3443.growfluent.Model.Module;
import edu.utsa.cs3443.growfluent.R;

public class LessonQuizController implements View.OnClickListener{
    private LessonQuizActivity quizActivity;
    private Module moduleN;
    private Lesson lesson;
    private Context context;
    private int lessonNum;
    private String lessonInfo;
    private EditText q1EditText;
    private EditText q2EditText;
    private EditText q3EditText;

    public LessonQuizController(LessonQuizActivity activity, int lessonNum, String lessonInfo){
        this.quizActivity = activity;
        this.lessonNum = lessonNum;
        this.moduleN = new Module();
        this.lessonInfo = lessonInfo;
        this.q1EditText = activity.findViewById(R.id.Q1English);
        this.q2EditText = activity.findViewById(R.id.Q2English);
        this.q3EditText = activity.findViewById(R.id.Q3English);
    }



    public void onClick(View view){
        boolean q1 = true;
        boolean q2 = true;
        boolean q3 = true;


        String q1Answer = q1EditText.getText().toString();
        String q2Answer = q2EditText.getText().toString();
        String q3Answer = q3EditText.getText().toString();

        context = view.getContext();

        if(view.getId() == R.id.SubmitQuiz){

            if(lessonNum == 1) {
                try {
                    moduleN.loadLesson(context, "Lesson1.csv");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                lesson = moduleN.getLesson(1);

                q1 = lesson.correctAnswer(q1Answer);
                q2 = lesson.correctAnswer(q2Answer);
                q3 = lesson.correctAnswer(q3Answer);
            }

            if(lessonNum == 2) {
                try {
                    moduleN.loadLesson(context, "Lesson2.csv");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                lesson = moduleN.getLesson(2);

                q1 = lesson.correctAnswer(q1Answer);
                q2 = lesson.correctAnswer(q2Answer);
                q3 = lesson.correctAnswer(q3Answer);
            }

            if(lessonNum == 3) {
                try {
                    moduleN.loadLesson(context, "Lesson3.csv");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                lesson = moduleN.getLesson(3);
                System.out.println(lesson);

                q1 = lesson.correctAnswer(q1Answer);
                q2 = lesson.correctAnswer(q2Answer);
                q3 = lesson.correctAnswer(q3Answer);
            }


            int numCorrect=0;
            if(q1 == true){
                numCorrect++;
            }
            if(q2 == true){
                numCorrect++;
            }
            if(q3 == true){
                numCorrect++;
            }

            if(view.getId() == R.id.SubmitQuiz) {
                if(q1 == true && q2 == true && q3 == true) {
                    System.out.println("SUCCESS: PASS");
                    Intent intent = new Intent(quizActivity, LessonPassActivity.class);
                    intent.putExtra("lessonNum", lessonNum);
                    intent.putExtra("lessonComplete", 1);
                    quizActivity.startActivity(intent);
                }
                else{
                    System.out.println("FAILURE: fail");
                    Intent intent = new Intent(quizActivity, LessonFailActivity.class);
                    intent.putExtra("numCorrect", numCorrect);
                    intent.putExtra("lessonNum", lessonNum);
                    quizActivity.startActivity(intent);
                }
            }
        }


    }
}