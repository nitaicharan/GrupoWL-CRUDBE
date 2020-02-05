package com.groupowl.crudbe.repositories;

import java.time.LocalDate;
import java.util.List;


import com.groupowl.crudbe.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "call get_users", nativeQuery = true)
    public List<UserEntity> getUsers();

    @Query(value = "call get_user(?1)", nativeQuery = true)
    public UserEntity getUser(final long id);

    @Query(value = "call update_user(?1,?2,?3,?4,?5)", nativeQuery = true)
    public void updateUser(final long id, final String nome, final String cpf, final LocalDate dataNascimento,
            final String senha);

    @Query(value = "call DELETE_USER(?1)", nativeQuery = true)
    public void deleteUser(final long id);

    @Query(value = "insert into user_entity (nome, cpf, data_nascimento, senha) values (?1,?2,?3,?4)", nativeQuery = true)
    public void createUser(final String nome, final String cpf, final LocalDate dataNascimento,
            final String senha);
}