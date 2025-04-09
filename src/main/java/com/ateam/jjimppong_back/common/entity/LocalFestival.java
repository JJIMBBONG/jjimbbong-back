package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name =  "localFestival")
@Table(name =  "localFestival")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalFestival {
    
    @Id
    private Integer festivalNumber;
    private String festivalDate;
    private String festivalName;
    private String festivalContent;
    private String festivalImage;
}
