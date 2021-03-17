package com.example.demo.controller;

import com.example.demo.model.Session;
import com.example.demo.model.Speaker;
import com.example.demo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/speaker/")
public class SpeakerController {

    @Autowired
     private SpeakerRepository speakerRepository;


    @GetMapping
    @RequestMapping("/")
    public List<Speaker>  fetchAllSpeaker(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker getSpeakerById(@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    @RequestMapping("add")
    public Speaker  addSpeaker( @RequestBody Speaker speaker ){
        return  speakerRepository.saveAndFlush(speaker);
    }


    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    //patch update part
    //put update all
    @RequestMapping(value = "update/{id}",method = RequestMethod.PATCH)
    public Speaker updateRecord(@PathVariable Long id, @RequestBody Speaker session){

        Speaker getExisting =  speakerRepository.getOne(id);
        BeanUtils.copyProperties(session,getExisting,"session_id");
        return speakerRepository.saveAndFlush(getExisting);
    }

}
