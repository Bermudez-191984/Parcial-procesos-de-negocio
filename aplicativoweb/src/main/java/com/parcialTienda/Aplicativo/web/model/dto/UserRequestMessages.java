package com.parcialTienda.Aplicativo.web.model.dto;
import com.parcialTienda.Aplicativo.web.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestMessages {
    @Valid
    @NotNull(message = "RequestMessage is required")
    private RequestMessage requestMessage;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RequestMessage {
        @NotNull(message = "MessageID is required")
        private String messageID;

        @Valid
        @NotNull(message = "User is required")
        private User user;

    }
}