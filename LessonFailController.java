package edu.utsa.cs3443.growfluent.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import edu.utsa.cs3443.growfluent.LessonFailActivity;
import edu.utsa.cs3443.growfluent.MainActivity;
import edu.utsa.cs3443.growfluent.R;

    public class LessonFailController implements View.OnClickListener {

        private LessonFailActivity lessonFailActivity;
        private Context context;
        private int numCorrect;
        private int lessonNum;

        public LessonFailController(LessonFailActivity lessonFailActivity, int numCorrect, int lessonNum){
            this.lessonFailActivity = lessonFailActivity;
            this.numCorrect = numCorrect;
            this.lessonNum= lessonNum;
        }
        public void onClick(View view) {
            context = view.getContext();

            if (view.getId() == R.id.Back) {
                Intent intent = new Intent(lessonFailActivity, MainActivity.class);
                intent.putExtra("numCorrect", numCorrect);
                intent.putExtra("lessonNum", lessonNum);
                lessonFailActivity.startActivity(intent);
            }
        }
    }