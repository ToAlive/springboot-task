package com.example.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        //发送简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("Spring Boot Mail Test");
        simpleMailMessage.setText("大大大大大黄黄黄");
        //邮件的接收者
        simpleMailMessage.setTo("1454290241@qq.com");
        //邮件的发送者
        simpleMailMessage.setFrom("2561498724@qq.com");
        mailSender.send(simpleMailMessage);
    }


    @Test
    public void test1() throws MessagingException {
        //发送复杂的邮件
        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //true：要上传邮件
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("Spring Boot Mail Test");
        mimeMessageHelper.setText("<h1>哈哈哈</h1>",true);

        //上传文件
        mimeMessageHelper.addAttachment("1.jpg",new File("001.jpg"));
        mimeMessageHelper.addAttachment("2.jpg",new File("002.jpg"));

        //邮件的接收者
        mimeMessageHelper.setTo("1454290241@qq.com");
        //邮件的发送者
        mimeMessageHelper.setFrom("2561498724@qq.com");


        mailSender.send(mimeMessage);
    }
}
