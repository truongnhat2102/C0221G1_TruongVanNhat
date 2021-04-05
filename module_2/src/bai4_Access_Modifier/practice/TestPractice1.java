package bai4_Access_Modifier.practice;

public class TestPractice1 {
    public static void main(String args[]) {
        practice1.change(); //calling change method

        //creating objects
        practice1 s1 = new practice1(111, "Hoang");
        practice1 s2 = new practice1(222, "Khanh");
        practice1 s3 = new practice1(333, "Nam");

        //calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}
