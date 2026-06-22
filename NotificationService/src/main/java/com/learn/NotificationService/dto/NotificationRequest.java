package com.learn.NotificationService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequest {

    @NotNull(message = "customer ID is required")
    private Long customerId;

    @NotBlank(message = "Message content is required")
    private String message;

    @NotBlank(message = "Status is required")
    private String status;
}
