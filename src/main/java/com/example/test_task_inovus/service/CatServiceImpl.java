package com.example.test_task_inovus.service;

import com.example.test_task_inovus.dto.CatDTO;
import com.example.test_task_inovus.model.Cat;
import com.example.test_task_inovus.repository.CatRepo;
import com.example.test_task_inovus.util.CatMapper;
import com.example.test_task_inovus.util.QueueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CatServiceImpl implements CatService{

    private final CatRepo catRepo;
    private final CatMapper catMapper;
    private final QueueUtil queueUtil;

    @Autowired
    public CatServiceImpl(CatRepo catRepo, CatMapper catMapper, QueueUtil queueUtil) {
        this.catRepo = catRepo;
        this.catMapper = catMapper;
        this.queueUtil = queueUtil;
    }

    @Override
    public List<Cat> findAll() {
        return catRepo.findAll();
    }

    @Override
    public Queue<Cat> findAllByRandom() {
        return queueUtil.getQueue10();
    }

    @Override
    public List<CatDTO> getTop10() {
        List<Cat> cats = findAll();
        List<CatDTO> catsDTO = catMapper.getCatListDTO(cats);
        return catsDTO.stream().sorted((c1, c2) -> -c1.getVote().compareTo(c2.getVote())).limit(10).collect(Collectors.toList());
    }

    @Override
    public List<CatDTO> getTwoCats() {
        Queue<Cat> list = queueUtil.getQueueAll();
        Cat one = list.poll();
        Cat two = list.poll();
        if (one == null || two == null) {
            return Collections.emptyList();
        }
        List<CatDTO> catsTwoListDTO = new ArrayList<>();
        catsTwoListDTO.add(catMapper.getCatDTO(one));
        catsTwoListDTO.add(catMapper.getCatDTO(two));
        return catsTwoListDTO;
    }

    @Override
    public Cat getId(Long id) {
        return catRepo.getById(id);
    }

    @Override
    public void increment(Long id) {
        Cat cat = getId(id);
        cat.setVote(cat.getVote()+1);
        catRepo.save(cat);
    }

    @Override
    public void save(Long id) {
        Cat cat = getId(id);
        catRepo.save(cat);
    }
}
