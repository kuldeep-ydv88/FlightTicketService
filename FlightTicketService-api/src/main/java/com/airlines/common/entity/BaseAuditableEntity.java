package com.airlines.common.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
public class BaseAuditableEntity {
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private String createdOn;
    @LastModifiedDate
    private String lastModifyOn;

}
