package com.example.test_task_inovus.service;


import com.example.test_task_inovus.dto.CatDTO;
import com.example.test_task_inovus.model.Cat;
import com.example.test_task_inovus.repository.CatRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

public interface CatService {

    Queue<Cat> findAllByRandom();

    List<Cat> findAll();

    List<CatDTO> getTop10();

    List<CatDTO> getTwoCats();

    Cat getId(Long id);

    void increment (Long id);
    void save(Long id);
}
