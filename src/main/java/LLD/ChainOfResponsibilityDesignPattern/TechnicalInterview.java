package LLD.ChainOfResponsibilityDesignPattern;

import java.util.Scanner;

public class TechnicalInterview extends InterviewHandler{

    @Override
    protected void hire(String candidate) {
        System.out.println("Enter the score of technical interview round for " + candidate + ": ");
        int score = new Scanner(System.in).nextInt();

        if(score >= 70) {
            System.out.println(candidate + " passed " + this.getClass().getSimpleName());
            System.out.println();
            callNext(candidate);
        } else {
            System.out.println(candidate + " failed " + this.getClass().getSimpleName());
        }
    }
}
