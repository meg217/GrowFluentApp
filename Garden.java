package edu.utsa.cs3443.growfluent.Model;

public class Garden {

    public int[][] lessonProgress = new int[3][3];
    public boolean lesson1;
    public boolean lesson2;
    public boolean lesson3;
    public Garden(int lessonNum, int numCorrect1, int numCorrect2, int numCorrect3, int totalQuestions){
        int i = 0;
        int j = 0;
        //beginning conditions
        if(lessonNum == 0){
            for(i = 0; i < 3; i++){
                j = 0;
                this.lessonProgress[i][j] = 0;
                j++;
                this.lessonProgress[i][j] = 0;
            }
        }
        else{
            //check to see user has already finished lesson with maximum points
            //Lesson1
            //if lesson is complete
            if(lesson1 == true){
                lessonProgress[0][0] = totalQuestions;
            }
            else{
                lessonProgress[0][0] = numCorrect1;
            }
            lessonProgress[0][1] = totalQuestions;

            //Lesson2
            if(lesson2 == true){
                lessonProgress[1][0] = totalQuestions;
            }
            else{
                lessonProgress[1][0] = numCorrect2;
            }
            lessonProgress[1][1] = totalQuestions;

            //Lesson3
            if(lesson3 == true){
                lessonProgress[2][0] = totalQuestions;
            }
            else{
                lessonProgress[2][0] = numCorrect3;
            }
            lessonProgress[2][1] = totalQuestions;


            //After most recent attempt, check to see if user has achieved maximum points in lesson

            /*if(lessonProgress[0][0] == totalQuestions){
                lesson1 = true;
            }
            if(lessonProgress[1][0] == totalQuestions){
                lesson2 = true;
            }
            if(lessonProgress[2][0] == totalQuestions){
                lesson3 = true;
            }*/

        }

    }

}