package com.github.princeflaco.template.scf.ct.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 30)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean isValidated;
    @Column(nullable = false)
    private String password;
}
