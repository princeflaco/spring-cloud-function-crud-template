package com.github.princeflaco.template.scf.ct.core.repository;

import com.github.princeflaco.template.scf.ct.core.domain.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User getById(String id);
    List<User> getAll();
    void deleteById(String id);

}
