package edu.utsa.cs3443.growfluent.Model;

public class User {
    public int[][] lessonProgress = new int[3][3];

    public User(int lessonNum, int numCorrect, int allCorrect){
        int i = 0;
        int j = 0;
        if(lessonNum == 0){
            for(i = 0; i < 3; i++){
                j = 0;
                this.lessonProgress[i][j] = 0;
                j++;
                this.lessonProgress[i][j] = 0;
            }
        }
        else{
            this.setProgress(lessonNum, numCorrect, allCorrect);
        }

        //this.lessonProgress[lessonNum-1][0] = numCorrect;
        //this.lessonProgress[lessonNum-1][1] = allCorrect;
    }

    public String toString(int i){
        String output = "Lesson " + i + ": \n" + lessonProgress[i-1][0] + "/" + lessonProgress[i-1][1] + " correct\n";
        return output;
    }

    public void setProgress(int lessonNum, int numCorrect, int allCorrect){
        this.lessonProgress[lessonNum-1][0] = numCorrect;
        this.lessonProgress[lessonNum-1][1] = allCorrect;
    }
}
