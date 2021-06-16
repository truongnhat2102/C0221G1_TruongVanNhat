package condiment.service;

import java.util.List;

public interface ICondiment {
    void saveConmediant(String conmediant);

    List<String> findByAll();
}
