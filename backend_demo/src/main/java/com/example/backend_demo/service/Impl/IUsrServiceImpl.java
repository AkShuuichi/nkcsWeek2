package com.example.backend_demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend_demo.entity.Usr;
import com.example.backend_demo.mapper.UsrTable;
import com.example.backend_demo.service.IUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Service
public class IUsrServiceImpl extends ServiceImpl<UsrTable, Usr> implements IUsrService {
    @Resource
    private UsrTable usrMapper;

    @Override
    public List<Usr> findAll(){
        List<Usr> usrList = usrMapper.findAll();
        return usrList;
    }

    @Override
    public Usr findById(int id) {
        Usr usr = usrMapper.findById(id);
        return usr;
    }

    @Override
    public void add(Usr usr){
        usrMapper.add(usr);
    }

    @Override
    public void delete(int id){
        usrMapper.delete(id);
    }

    @Override
    @Transactional
    public void update(Usr usr){
        usrMapper.update(usr);
    }


}
