package com.example.demo_crud.KhachHangModule.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class customerRequest {
    private String username;
    private String password;
}