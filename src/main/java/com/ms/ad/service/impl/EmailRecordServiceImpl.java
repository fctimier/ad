package com.ms.ad.service.impl;

import com.ms.ad.model.EmailRecord;  
import com.ms.ad.mapper.EmailRecordMapper;  
import com.ms.ad.service.EmailRecordService;  
import lombok.RequiredArgsConstructor;  
import org.springframework.stereotype.Service;  

import java.util.List;  

@Service  
@RequiredArgsConstructor  
public class EmailRecordServiceImpl implements EmailRecordService {  
    private final EmailRecordMapper emailRecordMapper;  

    @Override  
    public EmailRecord getById(Long id) {  
        return emailRecordMapper.selectById(id);  
    }  

    @Override  
    public List<EmailRecord> list() {  
        return emailRecordMapper.selectList(null);  
    }  

    @Override  
    public void saveEmailRecord(EmailRecord emailRecord) {  
        emailRecordMapper.insert(emailRecord);  
    }  

    @Override  
    public void updateEmailRecord(EmailRecord emailRecord) {  
        emailRecordMapper.updateById(emailRecord);  
    }  

    @Override  
    public void deleteEmailRecord(Long id) {  
        emailRecordMapper.deleteById(id);  
    }  
}