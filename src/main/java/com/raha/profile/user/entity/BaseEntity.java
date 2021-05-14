package com.raha.profile.user.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    LocalDateTime localDateTime;

    @UpdateTimestamp
    LocalDateTime updateDate;
}
