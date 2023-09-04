package com.kempaiah.company.entity;

import java.io.Serializable;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {

  @CreationTimestamp
  private String createdOn;
  private String createdBy;
  private String modifiedOn;
  private String modifiedBy;
}
