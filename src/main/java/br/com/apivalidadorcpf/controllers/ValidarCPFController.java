package br.com.apivalidadorcpf.controllers;

import br.com.apivalidadorcpf.models.Status;
import br.com.apivalidadorcpf.services.ValidaCPFService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Validação")
@RestController
public class ValidarCPFController {

    private final String ABLE_TO_VOTE = "ABLE_TO_VOTE";
    private final String UNABLE_TO_VOTE = "UNABLE_TO_VOTE";
    private final ValidaCPFService service;

    public ValidarCPFController(ValidaCPFService service) {
        this.service = service;
    }

    @GetMapping("/users/{cpf}")
    @Operation(summary = "Consultar todos os produtos")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    @ApiResponse(responseCode = "404", description = "CPF inválido")
    public ResponseEntity<Status> validarCPF(@PathVariable String cpf) {
        boolean isValid = this.service.validar(cpf);
        if (isValid) {
            return ResponseEntity.ok().body(Status.created().withStatus(ABLE_TO_VOTE));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Status.created().withStatus(UNABLE_TO_VOTE));
        }

    }
}
