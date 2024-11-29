package com.ms.ad.model;  

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;  
import lombok.Data;  

import java.util.Date;  

@Data  
@TableName("email_records")  
public class EmailRecord {  
    @TableId(type = IdType.AUTO)
    private Long id; // 主键  
    private String recipient; // 收件人  
    private String subject;   // 邮件主题  
    private String content;   // 邮件内容  
    private Date sentTime;    // 发送时间  
    private String status;     // 发送状态  
    private String errorMessage; // 错误信息  
}