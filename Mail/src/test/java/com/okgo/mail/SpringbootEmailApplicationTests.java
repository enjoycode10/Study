package com.okgo.mail;

import com.okgo.mail.config.EmailConfig;
import com.okgo.mail.service.EmailService;
import com.okgo.mail.service.Impl.EmailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEmailApplicationTests {

    @Autowired
    private EmailConfig emailConfig;
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendAttachmentEmailTest() {
        //创建发送附件邮箱的对象
        MimeMessage msg = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setFrom(emailConfig.getEmailFrom());
            helper.setTo("1052842812@qq.com");
            helper.setSubject("title");

            helper.setText("content");

            FileSystemResource fileSystemResource = new FileSystemResource(new File("C:\\Userdata\\MyFiles\\Spring\\Study\\Mail\\readme.md"));
            helper.addAttachment("附件", fileSystemResource);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(msg);

    }

}
