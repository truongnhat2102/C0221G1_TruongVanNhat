package bai5_Inheritance.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Point3D extends Point2D {
    protected float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    protected float getZ() {
        return z;
    }

    protected void setZ(float z) {
        this.z = z;
    }

    protected void setXYZ(float x, float y, float z) {
        super.getX();
        super.getY();
        this.z = z;
    }

    float[] getXYZ() {
        float[] arr = new float[3];
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;
        return arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(getXYZ());
    }
}

class Point3DTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter x:");
        float x = sc.nextFloat();
        System.out.println("enter y:");
        float y = sc.nextFloat();
        System.out.println("enter z:");
        float z = sc.nextFloat();
        Point3D point3D = new Point3D(x, y, z);
        System.out.println(point3D.toString());
    }
}
