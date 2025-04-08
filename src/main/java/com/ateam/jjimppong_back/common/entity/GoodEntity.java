package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "good")
@Table(name = "good")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodEntity {
    
    @Id
    private String userId;
    private Integer boardNumber;
}
