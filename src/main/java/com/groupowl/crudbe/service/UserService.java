package com.groupowl.crudbe.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.groupowl.crudbe.entities.UserEntity;
import com.groupowl.crudbe.repositories.UserRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository repository;

    public List<UserEntity> getUsers() {
        return this.repository.getUsers();
    }

    public UserEntity getUser(long id) {
        return this.repository.getUser(id);
    }

    public UserEntity getUser(UserEntity entity) {
        return this.repository.getUser(entity.getId());
    }

    public void updateUser(UserEntity entity) {
        this.repository.updateUser(entity.getId(), entity.getNome(), entity.getCpf(), entity.getDataNascimento(),
                entity.getSenha());
    }

    public void createUser(UserEntity entity) {
        entity.setSenha(generateEncryptPassword(entity.getCpf().substring(0, 3) + entity.getDataNascimento().getMonthValue()));
        this.repository.save(entity);
    }

    public void deleteUser(long id) {
        this.repository.deleteUser(id);
    }

    private String generateEncryptPassword(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}