package com.github.princeflaco.template.scf.ct.adapter.service;

import com.github.princeflaco.template.scf.ct.core.service.PasswordEncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordEncryptServiceImpl implements PasswordEncryptService {

    private final BCryptPasswordEncoder encoder;

    @Override
    public String encrypt(String password) {
        return encoder.encode(password);
    }
}
