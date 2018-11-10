package com.github.sacredrelict.api.common.component.email;

import com.github.sacredrelict.api.common.component.message.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

/**
 * Component for sending emails.
 */
@Component
public class EmailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

    @Value(value = "${spring.mail.username}")
    private String MAIL_USERNAME;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private Messages messages;

    /**
     * Send email with easy plain text.
     * @param to - email to.
     * @param subject - email subject.
     * @param text - email body.
     * @return status.
     */
    public EmailStatus sendPlainText(String to, String subject, String text) {
        return sendM(to, subject, text, false);
    }

    /**
     * Send email using html templates.
     * @param to - email to.
     * @param subject - email subject.
     * @param templateName - templates from resources/templates.
     * @param context - current Context.
     * @return status.
     */
    public EmailStatus sendHtml(String to, String subject, String templateName, Context context) {
        String body = templateEngine.process(templateName, context);
        return sendM(to, subject, body, true);
    }

    /**
     * Base method to send emails.
     * @param to - email to.
     * @param subject - email subject.
     * @param text - email body.
     * @param isHtml - flag is HTML or not.
     * @return status.
     */
    private EmailStatus sendM(String to, String subject, String text, Boolean isHtml) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setFrom(MAIL_USERNAME);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            javaMailSender.send(mail);
            LOGGER.info(String.format(messages.get("email.send.default.message"), subject, to));
            return new EmailStatus(to, subject, text).success();
        } catch (Exception e) {
            LOGGER.error(String.format(messages.get("email.send.problem"), to, e.getMessage()));
            return new EmailStatus(to, subject, text).error(e.getMessage());
        }
    }


}
