package com.github.princeflaco.template.scf.ct.adapter.controller;

import com.github.princeflaco.template.scf.ct.adapter.controller.dto.UserDTO;
import com.github.princeflaco.template.scf.ct.adapter.controller.dto.response.CreatedDTO;
import com.github.princeflaco.template.scf.ct.adapter.controller.dto.response.ErrorDTO;
import com.github.princeflaco.template.scf.ct.core.domain.User;
import com.github.princeflaco.template.scf.ct.core.usecase.UserUseCase;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class CreateUserHandler {
    private final UserUseCase userUseCase;
    private final ModelMapper modelMapper;

    @FunctionName("create-user")
    public HttpResponseMessage run(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.FUNCTION,
                    route = "users"
            ) HttpRequestMessage<UserDTO> request,
            final ExecutionContext context) {

        Logger logger = context.getLogger();
        userUseCase.setLogger(logger);
        logger.info("Headers:\n" + request.getHeaders());

        try {
            User user = userUseCase.save(modelMapper.map(request.getBody(), User.class));
            return request.createResponseBuilder(HttpStatus.CREATED).body(new CreatedDTO(user.getId())).build();
        } catch (IllegalArgumentException e) {
            logger.warning("User not created: " + e.getMessage());
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage())).build();
        } catch (Exception e) {
            logger.severe("An unexpected error occurred: " + e.getMessage());
            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(e.getMessage())).build();
        }
    }
}
