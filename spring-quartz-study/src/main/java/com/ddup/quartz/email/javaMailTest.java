package com.ddup.quartz.email;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class javaMailTest {

    private static final String HOST = "smtp.163.com";   // 发送邮件邮箱的配置
    private static final Integer PORT = 25;
    private static final String USERNAME = "wanjin.hao@woqutech.com";//163邮箱账号
    private static final String PASSWORD = "97495Hwj";//163邮箱---授权码
    private static final String EMAILFORM = "郝万金";  //发送邮件的用户
    private static JavaMailSenderImpl mailSender = createMailSender();


    private static final String EMAILNAME = "数据异常报告";  //收到邮件显示对方邮件名称 总体名称
    private static final String EMAILTOPNAME = "定时任务1数据采集异常";  //邮件名称

    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    private static JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);
        sender.setPort(PORT);
        sender.setUsername(USERNAME);
        sender.setPassword(PASSWORD);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", "25000");
        p.setProperty("mail.smtp.auth", "false");
        sender.setJavaMailProperties(p);
        return sender;
    }

    /**
     * 发送邮件
     * @param to      邮件接收人
     * @param subject 主题
     * @param html    发送内容
     */
    public static void sendHtmlMail(String to, String subject, String html) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            // 设置utf-8或GBK编码，否则邮件会有乱码
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            messageHelper.setFrom(EMAILFORM, EMAILNAME);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(html, true);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
     sendHtmlMail("769671508@qq.com", EMAILTOPNAME, "数据入库异常！ CoderZS 我在简书等你");
    }

}