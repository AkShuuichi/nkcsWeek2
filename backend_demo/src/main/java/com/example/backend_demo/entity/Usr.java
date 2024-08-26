package com.example.backend_demo.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "usr")
public class Usr {
    private int id;
    private String name;
    private String password;

    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(String password) {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
