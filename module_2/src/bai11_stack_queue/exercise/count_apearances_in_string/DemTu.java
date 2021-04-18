package bai11_stack_queue.exercise.count_apearances_in_string;

import java.util.HashMap;
import java.util.Map;

public class DemTu {
    public static void main(String[] args) {
        String str = "hello words hello words lan huệ";
        String[] arr = str.split(" ");
        String key = "";
        int value;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            key=arr[i];
            if(!map.containsKey(key)){
                map.put(key,1);
            }else {
                value=map.get(key);
                map.remove(key);
                map.put(key,value+1);
            }
        }
        System.out.println(map.toString());
    }
}
