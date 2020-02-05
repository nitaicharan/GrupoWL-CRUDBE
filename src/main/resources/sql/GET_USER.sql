CREATE
OR REPLACE PROCEDURE `vjahw6pw9iam51ut`.`GET_USER`(IN idIn bigint(20)) BEGIN
SELECT
    *
FROM
    user_entity
WHERE
    id = idIN;

END