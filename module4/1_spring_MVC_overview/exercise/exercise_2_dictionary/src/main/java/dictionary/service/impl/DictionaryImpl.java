package dictionary.service.impl;

import dictionary.service.IDictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictionaryImpl implements IDictionary {
    List<String> vietnamese = new ArrayList<>();
    List<String> english = new ArrayList<>();

    @Override
    public String translate(String text, int i) {
        vietnamese.add("chao");
        vietnamese.add("toi");
        vietnamese.add("ten");
        vietnamese.add("la");
        english.add("hello");
        english.add("my");
        english.add("name");
        english.add("is");
        String translate = null;
        String[] texts = text.split(" ");
        switch (i){
            case 1:
                translate = findWords(vietnamese,english,texts).toString();
                break;
            case 2:
                translate = findWords(english,vietnamese,texts).toString();
                break;
            default:
                translate = text;
                break;
        }
        return translate;
    }

    @Override
    public List<String> findWords(List<String> stringList1, List<String> stringList2 ,String[] texts) {
        List<String> translate = new ArrayList<>();
        for (int j = 0; j < texts.length; j++) {
            boolean check = true;
            for (int k = 0; k < stringList1.size(); k++) {
                if (texts[j].equals(stringList1.get(k))){
                    translate.add(stringList2.get(k));
                    check = false;
                    break;
                }
            }
            if (check){
                translate.add(texts[j]);
            }
        }
        return translate;
    }
}
