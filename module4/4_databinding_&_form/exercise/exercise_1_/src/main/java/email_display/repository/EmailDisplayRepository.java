package email_display.repository;

import email_display.model.EmailDisplay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailDisplayRepository {
    List<EmailDisplay> emailDisplayList = new ArrayList<>();

    public List<EmailDisplay> findByAll(){
        return emailDisplayList;
    }

    public EmailDisplay findBySignature(String signature){
        EmailDisplay emailDisplay = null;
        for (int i = 0; i < emailDisplayList.size(); i++) {
            if (signature.equals(emailDisplayList.get(i).getSignature())){
                emailDisplay = emailDisplayList.get(i);
                break;
            }
        }
        return emailDisplay;
    }

    public boolean addDisplay(EmailDisplay emailDisplay){
        emailDisplayList.add(emailDisplay);
        return true;
    }

    public boolean editDisplay(EmailDisplay emailDisplay){
        boolean check = false;
        for (int i = 0; i < emailDisplayList.size(); i++) {
            if (emailDisplay.getSignature().equals(emailDisplayList.get(i).getSignature())){
                emailDisplayList.get(i).setLanguage(emailDisplay.getLanguage());
                emailDisplayList.get(i).setPageSize(emailDisplay.getPageSize());
                emailDisplayList.get(i).setSpamFilter(emailDisplay.isSpamFilter());
                check = true;
            }
        }
        return check;

    }
}
