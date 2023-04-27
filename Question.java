package edu.utsa.cs3443.growfluent.Model;
//this should be complete
    public class Question {

        private String spanishW;
        private String englishW;

        public Question(String englishW, String spanishW){
            this.spanishW = spanishW;
            this.englishW = englishW;
        }

        public String getSpanishW() {return spanishW;}
        public String getEnglishW() {return englishW;}

        public void setSpanishW(String spanishW) {this.spanishW = spanishW;}
        public void setEnglishW(String englishW) {this.englishW = englishW;}
    }
