package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "emailAuth")
@Table(name = "email_auth")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailAuthEntity {

    @Id
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "auth_number")
    private String authNumber;
    
}