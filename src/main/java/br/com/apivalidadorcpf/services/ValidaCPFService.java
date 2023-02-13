package br.com.apivalidadorcpf.services;

import br.com.caelum.stella.validation.CPFValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ValidaCPFService {

    public boolean validar(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

}