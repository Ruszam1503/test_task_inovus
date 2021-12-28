package com.example.test_task_inovus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatDTO {
    private Long id;
    private String Name;
    private Integer vote;
    private String base64Image;

    public CatDTO() {
    }

    public CatDTO(Long id, String name, Integer vote, String base64Image) {
        this.id = id;
        Name = name;
        this.vote = vote;
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "CatDto{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", vote=" + vote +
                ", base64Image='" + base64Image + '\'' +
                '}';
    }
}
