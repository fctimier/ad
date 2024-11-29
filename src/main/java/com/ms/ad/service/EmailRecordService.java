package com.ms.ad.service;  

import com.ms.ad.model.EmailRecord;  

import java.util.List;  

public interface EmailRecordService {  
    EmailRecord getById(Long id);  
    List<EmailRecord> list();  
    void saveEmailRecord(EmailRecord emailRecord);  
    void updateEmailRecord(EmailRecord emailRecord);  
    void deleteEmailRecord(Long id);  
}