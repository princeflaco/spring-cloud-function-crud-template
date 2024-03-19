package com.github.princeflaco.template.scf.ct.core.usecase;

import com.github.princeflaco.template.scf.ct.core.domain.User;
import com.github.princeflaco.template.scf.ct.core.repository.UserRepository;
import com.github.princeflaco.template.scf.ct.core.service.PasswordEncryptService;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class UserUseCase {

    private final PasswordEncryptService passwordEncryptService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Setter
    private Logger logger;

    public UserUseCase(UserRepository userRepository, PasswordEncryptService passwordEncryptService, ModelMapper modelMapper) {
        this.passwordEncryptService = passwordEncryptService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public User save(User user) {
        checkLogger();
        logger.log(Level.INFO, "Starting user saving process for: {0}", user.getUsername());

        String encryptedPassword = passwordEncryptService.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);
        logger.log(Level.INFO, "Password encrypted for user: {0}", user.getUsername());

        user.setIsValidated(false);

        User newUser = userRepository.save(user);
        logger.log(Level.INFO, "User saved successfully with ID: {0}", newUser.getId());

        return newUser;
    }

    public User get(String id) {
        checkLogger();
        logger.log(Level.INFO, "Fetching user with ID: {0}", id);
        User user = userRepository.getById(id);
        logger.log(Level.INFO, "User fetched successfully with ID: {0}", user.getId());
        return user;
    }

    public List<User> list() {
        checkLogger();
        logger.log(Level.INFO, "Listing all users");
        List<User> users = userRepository.getAll();
        logger.log(Level.INFO, "Total users listed: {0}", users.size());
        return users;
    }

    public void delete(String id) {
        checkLogger();
        logger.log(Level.INFO, "Deleting user with ID: {0}", id);
        userRepository.deleteById(id);
        logger.log(Level.INFO, "User deleted successfully with ID: {0}", id);
    }

    public void update(User user) {
        checkLogger();
        logger.log(Level.INFO, "Updating user with ID: {0}", user.getId());
        User currentUser = userRepository.getById(user.getId());
        modelMapper.map(user, currentUser);
        save(currentUser);
        logger.log(Level.INFO, "User updated successfully with ID: {0}", currentUser.getId());
    }

    private void checkLogger() {
        if (this.logger == null) {
            setLogger(Logger.getLogger(UserUseCase.class.getName()));
        }
    }
}
