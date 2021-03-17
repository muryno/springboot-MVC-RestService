package com.example.demo.controller;


import com.example.demo.model.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/v1/session/")
public class SessionController {

    @Autowired
    public SessionRepository sessionRepository;

    @GetMapping
    public ResponseEntity<List<Session>>  getAllSession(){
        return new ResponseEntity<> (sessionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Session> findById(@PathVariable Long id){
        return  new ResponseEntity<> (sessionRepository.getOne(id), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping(value = "add")
    public  Session creatSession(@RequestBody Session session){
      return   sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }



    //patch update part
    //put update all
    @RequestMapping(value = "update/{id}",method = RequestMethod.PATCH)
    public Session updateRecord(@PathVariable Long id,@RequestBody Session session){

        Session getExisting =  sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,getExisting,"session_id");
        return sessionRepository.saveAndFlush(getExisting);
    }


}
