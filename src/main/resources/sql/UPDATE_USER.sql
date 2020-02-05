CREATE
OR REPLACE PROCEDURE `vjahw6pw9iam51ut`.`UPDATE_USER`(
    IN idIn BIGINT(20),
    in nomeIn varchar(255),
    IN cpfIn VARCHAR(255),
    IN data_nascimentoIn DATE,
    IN senhaIn VARCHAR(255)
) BEGIN
UPDATE
    user_entity
SET
    id = idIn,
    nome = nomeIn,
    cpf = cpfIn,
    data_nascimento = data_nascimentoIn,
    senha = senhaIn
WHERE
    id = idIn;

END