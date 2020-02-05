package com.groupowl.crudbe.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Pattern(regexp = "[a-zA-Z ]+")
    @NotBlank
    private String nome;

    @CPF(message = "CPF ${validatedValue} inválido")
    private String cpf;

    // @PastOrPresent
    private LocalDate dataNascimento;

    private String senha;
}