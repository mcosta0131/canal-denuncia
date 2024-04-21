package com.fiap.axur.canaldenuncia.controller;

import com.fiap.axur.canaldenuncia.model.DenunciaFraudeDTO;
import com.fiap.axur.canaldenuncia.service.DenunciaFraudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/denuncia/fraude")
public class DenunciaFraudeController {

    @Autowired
    private DenunciaFraudeService service;

    @PostMapping
    public void saveSuspeitaFraude(MultipartFile imagem,
                                   @RequestParam("numero") String numero,
                                   @RequestParam("nome") String nome) {
        try {
            // Verifica se o arquivo enviado é uma imagem
            if (!imagem.getContentType().startsWith("image")) {
                System.out.println("Arquivo enviado não é uma imagem.");
                return;
            }

            // Converte a imagem para base64
            byte[] bytesImagem = imagem.getBytes();
            String imagemBase64 = Base64.getEncoder().encodeToString(bytesImagem);
            DenunciaFraudeDTO denunciaFraudeDTO = new DenunciaFraudeDTO(nome, numero, imagemBase64);
            service.save(denunciaFraudeDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
