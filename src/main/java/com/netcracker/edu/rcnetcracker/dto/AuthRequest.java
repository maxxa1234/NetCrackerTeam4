package com.netcracker.edu.rcnetcracker.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
