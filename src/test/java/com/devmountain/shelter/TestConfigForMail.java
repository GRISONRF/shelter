package com.devmountain.shelter;

import jakarta.mail.internet.MimeMessage;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Properties;

@TestConfiguration
public class TestConfigForMail {

    @Bean
    public JavaMailSender mailSender() {
        final JavaMailSenderImpl sender = new MockMailSender();
        return sender;
    }

    private class MockMailSender extends JavaMailSenderImpl {
        @Override
        public void send(final MimeMessagePreparator mimeMessagePreparator) throws MailException {
            final MimeMessage mimeMessage = createMimeMessage();
            try {
                mimeMessagePreparator.prepare(mimeMessage);
                final String content = (String) mimeMessage.getContent();
                final Properties javaMailProperties = getJavaMailProperties();
                javaMailProperties.setProperty("mailContent", content);
            } catch (final Exception e) {
                throw new MailPreparationException(e);
            }
        }
    }
}
