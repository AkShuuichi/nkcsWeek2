package com.example.backend_demo.controller;

import com.example.backend_demo.entity.Usr;
import com.example.backend_demo.service.IUsrService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/usr")
public class UsrController {
    @Autowired(required = false)
    private IUsrService iUsrService;

    @GetMapping
    public List<Usr> findAll() {
        List<Usr> usrList = iUsrService.findAll();
        return usrList;
    }

    @GetMapping("/{id}")
    public Usr findById(@PathVariable int id) {
        Usr usr = iUsrService.findById(id);
        return usr;
    }

    @PostMapping(value = "/add", consumes = {"application/json"})
    public ResponseEntity<String> add(@RequestBody  Usr usr) {
        System.out.println("usr  "+usr.getName());
        iUsrService.add(usr);
        return ResponseEntity.ok().body("success");
    }

    @DeleteMapping("/items/{id}")
    @ResponseBody
    public void delete(@PathVariable int id) {
        iUsrService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id,
                      @RequestBody Usr usr) {
        usr.setId(id);
        iUsrService.update(usr);
    }

    @GetMapping("/hello")
    public String Hello(){
        return "Hello World";
    }


}
