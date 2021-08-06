package com.spring.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.spring.domain.User;
import com.spring.spring.dto.UserDTO;
import com.spring.spring.repository.UserRepository;
import com.spring.spring.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public void delete(String id){
        try {
            userRepository.deleteById(id);       
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException(id);
        }     
    }

    public User update(User obj){
        User user =  userRepository.findById(obj.getId()).get();
        updateData(user, obj);
        return userRepository.save(user);
    }

    private void updateData(User user, User obj) {
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
