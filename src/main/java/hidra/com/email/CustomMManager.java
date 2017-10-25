package hidra.com.email;

import java.io.Serializable;

public interface CustomMManager extends Serializable {
    void sendMail(String mailFrom,String mailTo,String subject,String mailBody);
}