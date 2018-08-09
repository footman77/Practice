package javamail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Demo1 {
    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        //链接的发邮件的服务器地址
        props.setProperty("mail.host","smtp.126.com");
        //指定进行验证登陆
        props.setProperty("mail.smtp.auth","true");
        //创建一个session对象，连接和登陆服务器
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("footman77@126.com", "XY569461298");
            }
        });

        session.setDebug(true);

        //发送一封邮件
        MimeMessage mail = new MimeMessage(session);

        //设置发件人
        mail.setFrom(new InternetAddress("footman77@126.com"));

        //设置收件人
        mail.setRecipient(Message.RecipientType.TO,new InternetAddress("ykkwpp@163.com"));

        //设置主题
        mail.setSubject("测试邮件");

        //设置内容
        mail.setContent("你好啊","text/plain;charset=utf-8");

        //发送邮件
        Transport.send(mail);
    }
}
