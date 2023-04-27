package edu.utsa.cs3443.growfluent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import edu.utsa.cs3443.growfluent.Model.Lesson;
import edu.utsa.cs3443.growfluent.R;

import java.io.Serializable;
import java.util.ArrayList;

import edu.utsa.cs3443.growfluent.Controller.LessonStartController;

public class LessonStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_start);
        Intent intent = getIntent();
        int lessonNum = intent.getIntExtra("lessonNum", 0);
        String lessonInfo = intent.getStringExtra("lessonInfo");
        TextView textView = findViewById(R.id.textViewStart);
        String[] parseInfo = lessonInfo.split(",");

        TextView spWord1 = findViewById(R.id.spWord1);
        spWord1.setText(parseInfo[4]);
        TextView spWord2 = findViewById(R.id.spWord2);
        spWord2.setText(parseInfo[5]);
        TextView spWord3 = findViewById(R.id.spWord3);
        spWord3.setText(parseInfo[6]);
        TextView engWord1 = findViewById(R.id.engWord1);
        engWord1.setText(parseInfo[0]);
        TextView engWord2 = findViewById(R.id.engWord2);
        engWord2.setText(parseInfo[1]);
        TextView engWord3 = findViewById(R.id.engWord3);
        engWord3.setText(parseInfo[2]);


        if(lessonNum == 1){
            textView.setText("Hello! Welcome to lesson 1. In this lesson we’ll be learning basic greetings and goodbyes in spanish, to get you a solid introduction. The words we will be learning are, hola, buenos, dias, noches, and adios.\n" +
                    "\n" +
                    "Hola means hello\n" +
                    "“Hola!” \t\t\t“Hi!”\n" +
                    "\n" +
                    "Buenos means good, you can use this in front of a time of day to greet people!\n" +
                    "“Buenos morning!”    \t\t  \n“Good morning to you too!”\n" +
                    "\n" +
                    "Dias means morning, you can use this to specify the time of day it is.\n" +
                    "“Buenos Dias!” \t\t\n“Its a beautiful morning today”\n" +
                    "\n" +
                    "Noches means night, you can use this to specify the time of day it is.\n" +
                    "“Buenos noches!” \t\t\n“Have a good night my friend”\n" +
                    "\n" +
                    "Adios means goodbye\n" +
                    "“Adios”\t\t\t\t\n“Goodbye! Thank you for completing lesson 1”\n" +
                    "\n" +
                    "After you’re ready go ahead and press the “start quiz” button and you can quiz yourself over your knowledge! \n");


        }

        if(lessonNum == 2){
            textView.setText("Hello! Welcome to lesson 2. In this lesson we’ll be learning words related to our households so we can start talking about our spanish speaking family! The words we will be learning are, madre, padre, hermana, hermano, amiga. \n" +
                    "\n" +
                    "Madre means Mother\n" +
                    "“Hola Madre”   “Hi! Have a good day at school!”\n" +
                    "\n" +
                    "Papa means Father\n" +
                    "“Adios Padre”   “Goodbye son”\n" +
                    "\n" +
                    "Hermana means Sister\n" +
                    "“This is my Hermana”  “Hola! Its nice to meet you”\n" +
                    "\n" +
                    "Hermano means Brother\n" +
                    "“I want a Hermano” “Too bad its a girl!”\n" +
                    "\n" +
                    "Amiga means Friend\n" +
                    "“You are my best amiga!” “You’re my best friend too!\n" +
                    "After you’re ready go ahead and press the “start quiz” button and you can quiz yourself over your knowledge! \n");
        }
        if(lessonNum == 3){
            textView.setText("Hello! Welcome to lesson 3. In this lesson we’ll be learning words related to the names of our body parts. The words we will be learning are boca, mano, estomago, cabeza, and nariz.\n" +
                    "\n" +
                    "Boca means Mouth\n" +
                    "“I eat with my boca”   “I do too!”\n" +
                    "\n" +
                    "Mano means Hand\n" +
                    "“My mano hurts from banging it on the table”   “Ouch are you okay?”\n" +
                    "\n" +
                    "Nariz means Nose\n" +
                    "“I want to get my Nariz pierced” “I think that would look good on you”\n" +
                    "\n" +
                    "Estomago means Stomach\n" +
                    "“My estomago hurts” “I think you’re lactose intolerant”\n" +
                    "\n" +
                    "Cabeza means Head\n" +
                    "“My cabeza is cold” “Maybe you should wear a hat today”\n" +
                    "\n" +
                    "After you’re ready go ahead and press the “start quiz” button and you can quiz yourself over your knowledge! \n");
        }


        LessonStartController lessonStartController = new LessonStartController(this, lessonInfo, lessonNum);
        Button Back = findViewById(R.id.Back);
        Back.setOnClickListener(lessonStartController);

        Button StartQuiz = findViewById(R.id.StartQuiz);
        intent.putExtra("lessonInfo", lessonInfo);
        intent.putExtra("lessonNum", lessonNum);
        StartQuiz.setOnClickListener(lessonStartController);

    }

}
