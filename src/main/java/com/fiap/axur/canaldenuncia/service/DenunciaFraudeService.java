package com.fiap.axur.canaldenuncia.service;

import com.fiap.axur.canaldenuncia.model.DenunciaFraudeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class DenunciaFraudeService {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void save(DenunciaFraudeDTO denunciaFraudeDTO){
        mongoTemplate.save(denunciaFraudeDTO);
    }
}
