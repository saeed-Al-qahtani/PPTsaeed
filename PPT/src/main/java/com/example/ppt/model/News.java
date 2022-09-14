package com.example.ppt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "must be right the subject")
    private String Subject ;

    @NotEmpty(message = "must be right the New")
    private String New ;

    @NotEmpty(message = "must be right the Source")
    private String Source ;

}
