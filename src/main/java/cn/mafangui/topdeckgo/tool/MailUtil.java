package cn.mafangui.topdeckgo.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailUtil {

    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    @Autowired
    private static JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private static String from;

    public static void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            javaMailSender.send(message);
            logger.info("简单邮件已经发送。");
        }catch (Exception e){
            logger.error("发送邮件时发生异常！",e);
        }

    }

    public static void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            javaMailSender.send(message);
            logger.info("HTML邮件发送成功");
        } catch (MessagingException e) {
            logger.error("发送HTML邮件失败!",e);
        }
    }
}
