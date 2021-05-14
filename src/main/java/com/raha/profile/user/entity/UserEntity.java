package com.raha.profile.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Table(name = "user")
@Entity(name = "user")
public class UserEntity extends BaseEntity {
    private String userName;
    private String password;
}
