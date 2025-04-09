package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "hate")
@Table(name = "hate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HateEntity {
    
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "board_number")
    private Integer boardNumber;
}
