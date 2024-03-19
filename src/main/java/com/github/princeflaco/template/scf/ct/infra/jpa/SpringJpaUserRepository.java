package com.github.princeflaco.template.scf.ct.infra.jpa;

import com.github.princeflaco.template.scf.ct.infra.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringJpaUserRepository extends JpaRepository<UserEntity, String> {
}
