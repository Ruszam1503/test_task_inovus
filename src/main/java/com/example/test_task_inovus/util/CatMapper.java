package com.example.test_task_inovus.util;

import com.example.test_task_inovus.dto.CatDTO;
import com.example.test_task_inovus.model.Cat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatMapper {

    public CatDTO getCatDTO (Cat cat) {
        String base64Image = Decoder.getBase64Image(cat.getImage());
        CatDTO catDTO= new CatDTO(cat.getId(), cat.getName(), cat.getVote(), base64Image);
        return catDTO;
    }
    public List<CatDTO> getCatListDTO(List<Cat> cats) {
        List<CatDTO> CatsDTO = new ArrayList<>();
        for (Cat cat : cats) {
            CatsDTO.add(getCatDTO(cat));
        }
        return CatsDTO;
    }



}
