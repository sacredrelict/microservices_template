package com.github.sacredrelict.api.common.component.email;

import com.github.sacredrelict.api.ApplicationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.context.Context;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for EmailSender.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class EmailSenderTest {

    @Autowired
    @InjectMocks
    private EmailSender emailSender;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void sendHtmlTest_start_noException() throws Exception {
        Context context = new Context();
        context.setVariable("message", "blah-blah");
        EmailStatus emailStatus = emailSender.sendHtml("test@github.ch", "test message", "account-alert", context);
        assertThat(emailStatus.isSuccess()).isEqualTo(true);
    }

}
