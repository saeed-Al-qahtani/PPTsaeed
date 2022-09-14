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
@Data
@Entity
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "name can not be empty" )
    private String playerName ;


    @NotEmpty(message = "Write the problem describe")
    private String SiteProblem ;

    @NotEmpty(message = "Write the problem describe")
    private String MembersProblem ;



    private Integer userId;
}
