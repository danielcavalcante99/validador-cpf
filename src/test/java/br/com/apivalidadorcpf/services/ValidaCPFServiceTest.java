package br.com.apivalidadorcpf.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ValidaCPFServiceTest {

    @Autowired
    private ValidaCPFService service;

    @Test
    @DisplayName("Testando CPF válido")
    void cpfValido() {
        boolean isValid = this.service.validar("81773227025");
        assertTrue(isValid);
    }

    @Test
    @DisplayName("Testando CPF Incompleto")
    void cpfIncompleto() {
        boolean isValid = this.service.validar("817732");
        assertFalse(isValid);
    }

    @Test
    @DisplayName("Testando CPF com mais de 11 dígitos")
    void cpfMaisOnzeDigitos() {
        boolean isValid = this.service.validar("817732270255");
        assertFalse(isValid);
    }

    @Test
    @DisplayName("Testando CPF com caracteres especiais")
    void cpfComCaracteresEspeciais() {
        boolean isValid = this.service.validar("81.773.227-025");
        assertFalse(isValid);
    }

    @Test
    @DisplayName("Testando CPF com letras")
    void cpfComLetras() {
        boolean isValid = this.service.validar("81B73227A25");
        assertFalse(isValid);
    }
}