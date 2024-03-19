package com.github.princeflaco.template.scf.ct.adapter.repository;

import com.github.princeflaco.template.scf.ct.core.domain.User;
import com.github.princeflaco.template.scf.ct.core.repository.UserRepository;
import com.github.princeflaco.template.scf.ct.infra.jpa.SpringJpaUserRepository;
import com.github.princeflaco.template.scf.ct.infra.jpa.entity.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SpringJpaUserRepository jpaRepo;
    private final ModelMapper modelMapper;

    @Override
    public User save(User user) {
        UserEntity newUser = jpaRepo.save(modelMapper.map(user, UserEntity.class));
        return modelMapper.map(newUser, User.class);
    }

    @Override
    public User getById(String id) {
        return jpaRepo.findById(id).map(usr -> modelMapper.map(usr, User.class)).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public List<User> getAll() {
        return jpaRepo.findAll().stream().map(usr -> modelMapper.map(usr, User.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        if (jpaRepo.existsById(id)) {
            jpaRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }
}
