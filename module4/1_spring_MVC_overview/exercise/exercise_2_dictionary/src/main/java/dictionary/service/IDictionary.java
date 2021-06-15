package dictionary.service;

import java.util.List;

public interface IDictionary {
    String translate(String text, int i);

    List<String> findWords(List<String> stringList1, List<String> stringList2, String[] texts);
}
