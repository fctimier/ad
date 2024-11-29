package com.ms.ad.controller;  

import com.ms.ad.model.EmailRecord;  
import com.ms.ad.model.request.CreateEmailRequest;  
import com.ms.ad.model.response.EmailRecordResponse;  
import com.ms.ad.service.EmailRecordService;  
import lombok.RequiredArgsConstructor;  
import lombok.extern.slf4j.Slf4j;  
import org.springframework.web.bind.annotation.*;  

import java.util.List;  
import java.util.stream.Collectors;  

@RestController  
@RequestMapping("/email")  
@RequiredArgsConstructor  
@Slf4j  
public class EmailRecordController {  
    private final EmailRecordService emailRecordService;  

    @GetMapping("/{id}")  
    public EmailRecordResponse getEmailRecord(@PathVariable Long id) {  
        log.info("Fetching email record with ID: {}", id);  
        EmailRecord emailRecord = emailRecordService.getById(id);  
        return convertToResponse(emailRecord);  
    }  

    @GetMapping("/list")  
    public List<EmailRecordResponse> listEmailRecords() {  
        log.info("Fetching all email records");  
        return emailRecordService.list().stream()  
                .map(this::convertToResponse)  
                .collect(Collectors.toList());  
    }  

    @PostMapping("/create")  
    public void createEmailRecord(@RequestBody CreateEmailRequest createEmailRequest) {  
        log.info("Creating email record: {}", createEmailRequest);  
        EmailRecord emailRecord = new EmailRecord();  
        emailRecord.setRecipient(createEmailRequest.getRecipient());  
        emailRecord.setSubject(createEmailRequest.getSubject());  
        emailRecord.setContent(createEmailRequest.getContent());  
        emailRecordService.saveEmailRecord(emailRecord);  
    }  

    @PutMapping("/update")  
    public void updateEmailRecord(@RequestBody EmailRecord emailRecord) {  
        log.info("Updating email record: {}", emailRecord);  
        emailRecordService.updateEmailRecord(emailRecord);  
    }  

    @DeleteMapping("/delete/{id}")  
    public void deleteEmailRecord(@PathVariable Long id) {  
        log.info("Deleting email record with ID: {}", id);  
        emailRecordService.deleteEmailRecord(id);  
    }  

    private EmailRecordResponse convertToResponse(EmailRecord emailRecord) {  
        if (emailRecord == null) {  
            return null;  
        }  
        EmailRecordResponse response = new EmailRecordResponse();  
        response.setId(emailRecord.getId());  
        response.setRecipient(emailRecord.getRecipient());  
        response.setSubject(emailRecord.getSubject());  
        response.setContent(emailRecord.getContent());  
        response.setSentTime(emailRecord.getSentTime());  
        response.setStatus(emailRecord.getStatus());  
        response.setErrorMessage(emailRecord.getErrorMessage());  
        return response;  
    }  
}