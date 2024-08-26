package com.example.backend_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend_demo.entity.Usr;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUsrService extends IService<Usr> {
    List<Usr> findAll();
    Usr findById(int id);
    void add(Usr usr);
    void delete(int id);
    void update(Usr usr);
}
