package bai3_OOP.exercise;

import java.util.Scanner;

public class Fan {
    final int SLOW = 1;
    final int NORMAL = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean on = true;
    private String color = "blue";
    private double radius = 5;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String display() {
        String str = "";
        if (this.on) {
            return str += "" +
                    "speed: " + this.speed + "\n" +
                    "color: " + this.color + "\n" +
                    "radius: " + this.radius + "\n" + "fan is on";
        }
        return str += "" +
                "color: " + this.color + "\n" +
                "radius: " + this.radius + "\n" +
                "fan is off";
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        Fan fan2 = new Fan();
        fan2.setOn(false);
        fan2.setSpeed(fan2.NORMAL);
        fan2.setRadius(5);
        fan2.setColor("blue");
        System.out.println(fan1.display());
        System.out.println();
        System.out.println(fan2.display());
    }
}
