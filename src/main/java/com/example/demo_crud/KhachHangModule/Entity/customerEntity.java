package com.example.demo_crud.KhachHangModule.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// tạo bảng khách hàng tham chiếu đến database
// khai báo Annotion đế spring boot hiểu đây là Entity
@Entity
// khai báo cho phép tự khởi tạo contructor
@Data
@Table(name = "user")
// khởi tao contructor có tham số
@AllArgsConstructor
// khởi tạo contructor không tham số
@NoArgsConstructor
public class customerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String username;
    private String password;
    private String private_key;
}
