package com.ateam.jjimppong_back.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name =  "localFestival")
@Table(name =  "local_festival")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalFestival {
    
    @Id
    @Column(name = "festival_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer festivalNumber;

    @Column(name = "festival_date")
    private String festivalDate;

    @Column(name = "festival_name")
    private String festivalName;

    @Column(name = "festival_content")
    private String festivalContent;

    @Column(name = "festival_image")
    private String festivalImage;
}
