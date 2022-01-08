package com.example.spring.aop.springaop.data;


import com.example.spring.aop.springaop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    @TrackTime
    public String retrieveSomething() {
        return "Dao1";
    }
}
