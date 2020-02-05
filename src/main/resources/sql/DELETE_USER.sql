CREATE
OR REPLACE PROCEDURE `vjahw6pw9iam51ut`.`DELETE_USER`(IN idIn bigint(20)) BEGIN
DELETE FROM
    user_entity
WHERE
    id = idIN;

END