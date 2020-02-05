CREATE
OR REPLACE PROCEDURE `vjahw6pw9iam51ut`.`CREATE_USER`(
    in nomeIn varchar(255),
    IN cpfIn VARCHAR(255),
    IN data_nascimentoIn DATE,
    IN senhaIn VARCHAR(255)
) BEGIN
INSERT
    user_entity (
        nome,
        cpf,
        data_nascimento,
        senha
    )
VALUES
    (
        nomeIn,
        cpfIn,
        data_nascimentoIn,
        senhaIn
    );
END