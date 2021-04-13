package bai8_automated_test_TDD.exercise.next_day;

public class LeafYear {
    protected int year;
    protected boolean checkLeafYear(){
        if (year%400==0){
            return true;
        }
        else if (year%4==0 && year%100!=0 ){
            return true;
        }
        return false;
    }
}
