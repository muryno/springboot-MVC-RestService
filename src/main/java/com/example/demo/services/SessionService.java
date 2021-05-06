package com.example.demo.services;

import com.example.demo.model.BaseResponse;
import com.example.demo.model.Session;
import com.example.demo.repository.SessionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService  {


    SessionRepository repository;

    SessionService(SessionRepository repository){
        this.repository = repository;
    }



    public ResponseEntity<?> findSessionById(long id){


        try {
            Optional<Session>   myRepo =  repository.findById(id);
            if(myRepo.isPresent()){

                var result = new BaseResponse<>(myRepo.get(), true, "Fetch Successfully");

                return new ResponseEntity<>(result, HttpStatus.OK);
            }else{
                var result = new BaseResponse<>(null, false, "No data");

                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){

            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }

    }



}
