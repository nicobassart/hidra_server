package hidra.com.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service("mailManager")
public class SimpleOrderManager {
    private JavaMailSender mailSender;

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(final String mailFrom, final String mailTo, final String subject, final String mailBody) {
/*        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("nicobassart@gmail.com");
            //helper.setReplyTo("someone@locRalhost");
            helper.setFrom("nicobassart@gmail.com");
            helper.setSubject("Lorem ipsum");
            helper.setText("Lorem ipsum dolor sit amet [...]");
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {}
        mailSender.send(mail);*/
    	
    	
    	
        //return helper;
    	
    	
/*        try {
            mailSender.send(new MimeMessagePreparator() {
                public void prepare(MimeMessage mimeMessage)
                        throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
                            false, "UTF-8");
                    message.setFrom(mailFrom);
                    message.addTo(mailTo);
                    message.setSubject(subject);
                    message.setText(mailBody, true);
                }
            });
        } catch (MailSendException e) {
           System.out.println("ver" + e.toString());
        }*/
    }
}
