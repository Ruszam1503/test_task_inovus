package com.example.test_task_inovus.model;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "cat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cat  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String Name;

    @Column(name = "vote")
    private Integer vote;

    @Column(name = "image",columnDefinition="blob")
    private byte[] image;

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", vote=" + vote +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
