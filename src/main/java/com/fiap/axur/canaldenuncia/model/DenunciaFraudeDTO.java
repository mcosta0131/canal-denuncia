package com.fiap.axur.canaldenuncia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("denuncia_fraude")
public class DenunciaFraudeDTO {
    private String nome;
    private String numero;
    private String imgBase64;
}
