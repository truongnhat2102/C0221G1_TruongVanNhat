package bai3_OOP.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class StopWatch {
    private long startTime;
    private long endTime;

    StopWatch() {

    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long start() {
        setStartTime(System.currentTimeMillis());
        return getStartTime();
    }

    public long end() {
        setEndTime(System.currentTimeMillis());
        return getEndTime();
    }

    public long getEclapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        double[] arr= new double[100000];
        for (int i=0; i<100000; i++){
            arr[i]=Math.random()*100;
        }
        StopWatch sw=new StopWatch();
        sw.start();
//        for (int i=0; i<100000; i++){
//            for (int j=0; j<100000; j++){
//                if (arr[i]<arr[j]){
//                    double num=arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=arr[i];
//                }
//            }
//        }
        Arrays.sort(arr);
        sw.end();
        System.out.println(sw.getEclapsedTime());
        for (int i=0; i<10; i++){
            System.out.println(arr[i]);
        }
    }
}
