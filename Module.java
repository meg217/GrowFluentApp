package edu.utsa.cs3443.growfluent.Model;

import java.util.ArrayList;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Module {
    private ArrayList<Lesson> lessons = new ArrayList<Lesson>();

    //private ArrayList<Question> questions = new ArrayList<Question>;
    public ArrayList<Lesson> getLessons() {
        return lessons;
    } //get entire arrayList

    public Lesson getLesson(int lessonNum) {
        for (Lesson lesson : lessons) {
            if (lesson.getLessonNum() == lessonNum) {
                return lesson;
            }
        }
        return null;
    } //get single lesson based on lesson number

    //button lesson 1 is clicked, then loadLesson(context, lesson1.csv)
    public void loadLesson(Context context, String lessonFile) throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open(lessonFile);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Scanner sc = new Scanner(inputStreamReader);
        Lesson lesson = null;
        int counter = 0;
        int lessonNum = 0;
        int numQuestions = 0;
        String englishW = "";
        String spanishW = "";

        while (sc.hasNextLine()) {
            String line[] = sc.nextLine().split(",");
            if (counter == 0) {
                lessonNum = Integer.parseInt(line[0]);
                numQuestions = Integer.parseInt(line[1]);
                counter++;
            } else {
                englishW += line[0] + ",";
                spanishW += line[1] + ",";
            }
        }
        lesson = new Lesson(lessonNum, numQuestions, englishW, spanishW);
        lessons.add(lesson);
        loadQuestions(context, lesson, numQuestions, englishW, spanishW);

        System.out.println(lessonNum);
        System.out.println(numQuestions);
        System.out.println(englishW);
        System.out.println(spanishW);

        sc.close();
        inputStreamReader.close();
        inputStream.close();
    }

    public void loadQuestions(Context context, Lesson lesson, int numQuestions, String englishW, String spanishW) {
        String[] english = englishW.split(",");
        String[] spanish = spanishW.split(",");
        int i = 0;

        for (i = 0; i < numQuestions; i++) {
            Question question = new Question(english[i], spanish[i]);
            lesson.addQuestionToLesson(question);
        }
    }






}





