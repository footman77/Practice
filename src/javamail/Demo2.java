package javamail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class Demo2 {
    public static void main(String[] args) throws Exception {

        Properties props = new Properties();

        props.setProperty("mail.host","smtp.126.com");

        props.setProperty("mail.smtp.auth","true");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("footman77@126.com","XY569461298");
            }
        });


        MimeMessage mail = new MimeMessage(session);

        mail.setFrom(new InternetAddress("footman77@126.com"));

        mail.setRecipient(Message.RecipientType.TO,new InternetAddress("ykkwpp@163.com"));

        mail.setSubject("附件邮件");

        File file = new File("e:/aaa.txt");

        MimeBodyPart part = new MimeBodyPart();

        FileDataSource source = new FileDataSource(file);
        DataHandler handler = new DataHandler(source);

        part.setDataHandler(handler);

        part.setFileName(MimeUtility.decodeText(file.getName()));

        MimeMultipart mimeMultipart = new MimeMultipart();

        mimeMultipart.addBodyPart(part);


        mail.setContent(mimeMultipart);

        //发送邮件
        Transport.send(mail);
    }
}
