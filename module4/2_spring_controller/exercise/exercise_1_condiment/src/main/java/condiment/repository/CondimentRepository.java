package condiment.repository;

import java.util.ArrayList;
import java.util.List;

public class CondimentRepository {
    List<String> conmediantList = new ArrayList<>();
    public void add(String spices){
        String conmediant = null;
        if (spices != null){
            conmediant = conmediant+spices;
        }
        conmediantList.add(conmediant);
    }

    public List<String> findByAll(){
        return this.conmediantList;
    }
}
