package org.example.Api.dto;

public class ServerResponseDTO {
    private final int status;
    private final String message;

    public ServerResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
