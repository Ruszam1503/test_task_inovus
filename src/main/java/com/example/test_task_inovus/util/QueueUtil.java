package com.example.test_task_inovus.util;

import com.example.test_task_inovus.model.Cat;
import com.example.test_task_inovus.repository.CatRepo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class QueueUtil {
    private final CatRepo catRepo;
    private final Queue<Cat> catsQueue;
    private final Queue<Cat> catsAllQueue;

    public QueueUtil(CatRepo catRepo) {
        this.catRepo = catRepo;
        this.catsAllQueue = new LinkedList<>();
        this.catsQueue = new LinkedList<>();
    }

    @PostConstruct
    private void queue() {
        List<Cat> catsRandom = catRepo.findAll();
        Collections.shuffle(catsRandom);
        catsQueue.addAll(catsRandom);
    }

    public Queue<Cat> getQueue10() {
        return catsQueue;
    }

    @PostConstruct
    private void catsTwo() {
        List<Cat> list = catRepo.findAll();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                catsAllQueue.add(list.get(i));
                catsAllQueue.add(list.get(j));
            }
        }
    }

    public Queue<Cat> getQueueAll() {
        return catsAllQueue;
    }
}
