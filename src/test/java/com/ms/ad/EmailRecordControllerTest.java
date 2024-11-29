package com.ms.ad;

import com.ms.ad.model.EmailRecord;
import com.ms.ad.model.request.CreateEmailRequest;
import com.ms.ad.model.response.EmailRecordResponse;
import com.ms.ad.service.EmailRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmailRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private EmailRecordService emailRecordService;

    @BeforeEach
    public void setUp() {
        emailRecordService = Mockito.mock(EmailRecordService.class);
    }

    @Test
    public void testGetEmailRecord() throws Exception {
        EmailRecord emailRecord = new EmailRecord();
        emailRecord.setId(1L);
        emailRecord.setRecipient("test@example.com");
        emailRecord.setSubject("Test Subject");
        emailRecord.setContent("Test Content");
        emailRecord.setSentTime(new Date());
        emailRecord.setStatus("SENT");
        emailRecord.setErrorMessage(null);

        when(emailRecordService.getById(anyLong())).thenReturn(emailRecord);

        mockMvc.perform(get("/email/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.recipient").value("test@example.com"));
    }

    @Test
    public void testListEmailRecords() throws Exception {
        EmailRecord emailRecord = new EmailRecord();
        emailRecord.setId(1L);
        emailRecord.setRecipient("test@example.com");
        emailRecord.setSubject("Test Subject");
        emailRecord.setContent("Test Content");
        emailRecord.setSentTime(new Date());
        emailRecord.setStatus("SENT");
        emailRecord.setErrorMessage(null);

        List<EmailRecord> emailRecords = Arrays.asList(emailRecord);
        when(emailRecordService.list()).thenReturn(emailRecords);

        mockMvc.perform(get("/email/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].recipient").value("test@example.com"));
    }

    @Test
    public void testCreateEmailRecord() throws Exception {
        CreateEmailRequest request = new CreateEmailRequest();
        request.setRecipient("test@example.com");
        request.setSubject("Test Subject");
        request.setContent("This is a test email.");

        mockMvc.perform(post("/email/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"recipient\":\"test@example.com\",\"subject\":\"Test Subject\",\"content\":\"This is a test email.\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateEmailRecord() throws Exception {
        EmailRecord emailRecord = new EmailRecord();
        emailRecord.setId(1L);
        emailRecord.setRecipient("updated@example.com");
        emailRecord.setSubject("Updated Subject");
        emailRecord.setContent("This is an updated test email.");

        mockMvc.perform(put("/email/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"recipient\":\"updated@example.com\",\"subject\":\"Updated Subject\",\"content\":\"This is an updated test email.\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteEmailRecord() throws Exception {
        mockMvc.perform(delete("/email/delete/{id}", 1L))
                .andExpect(status().isOk());
    }
}