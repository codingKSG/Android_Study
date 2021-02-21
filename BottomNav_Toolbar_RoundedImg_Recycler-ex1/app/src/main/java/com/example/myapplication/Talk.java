package com.example.myapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talk {

    private Integer id;
    private String talkName;
    private String content;
    private String updateTime;
}
