package edu.utsa.cs3443.growfluent.Controller;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.io.IOException;

import edu.utsa.cs3443.growfluent.GardenActivity;
import edu.utsa.cs3443.growfluent.LessonsActivity;
import edu.utsa.cs3443.growfluent.MainActivity;
import edu.utsa.cs3443.growfluent.Model.Lesson;
import edu.utsa.cs3443.growfluent.Model.Module;
//import edu.utsa.cs3443.growfluent.Model.User;
import edu.utsa.cs3443.growfluent.Model.User;
import edu.utsa.cs3443.growfluent.R;


    public class MainController implements View.OnClickListener {
        private MainActivity mainActivity;
        //    private Module moduleN;
//    private Lesson lesson;
        private Context context;
        private int lessonNum;
        private int allCorrect;
        private int numCorrect;
        private User user;
        //private int lessonComplete;


        public MainController(MainActivity mainActivity, int lessonNum, int allCorrect, int numCorrect, User user){
            this.mainActivity = mainActivity;
            this.lessonNum = lessonNum;
            this.allCorrect = allCorrect;
            this.numCorrect = numCorrect;
            this.user = user;
            //this.lessonComplete = lessonComplete;
            //this.moduleN = new Module();
        }

        public void onClick(View view){
            context = view.getContext();

            if (view.getId() == R.id.Garden_button){
                Intent intent = new Intent(mainActivity, GardenActivity.class);
                intent.putExtra("numCorrect1", user.lessonProgress[0][0]);
                intent.putExtra("numCorrect2", user.lessonProgress[1][0]);
                intent.putExtra("numCorrect3", user.lessonProgress[2][0]);
                intent.putExtra("allCorrect", allCorrect);
                intent.putExtra("lessonNum", lessonNum);
                //intent.putExtra("lessonComplete", lessonComplete);
                mainActivity.startActivity(intent);
            }

            if(view.getId() == R.id.Lessons_button){
                Intent intent = new Intent(mainActivity, LessonsActivity.class);
                mainActivity.startActivity(intent);
            }

//        if(view.getId() == R.id.Community_button){
//            Intent intent = new Intent(mainActivity, CommunityActivity.class);
//            mainActivity.startActivity(intent)
//        }
//
//        if(view.getId() == R.id.Settings_button){
//            Intent intent = new Intent(mainActivity, SettingsActivity.class);
//            mainActivity.startActivity(intent)
//        }

        }




    }
