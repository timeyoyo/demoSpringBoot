package com.imooc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @GetMapping(value = "/girls")
    public List<Girl> getGirlsList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl x = new Girl();
        x.setAge( age );
        x.setCpuSize( cupSize );
        return girlRepository.save( x );
    }

//    @GetMapping(value = "/girls/{id}")
//    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
//        return girlRepository.findById( id );
//    }

    @PutMapping(value = "/girls/{id}")
    public Girl updateOneGirl(@PathVariable("id") Integer id,
                              @RequestParam("cupSize") String cupSize,
                              @RequestParam("age") Integer age) {
        Girl x = new Girl();
        x.setId( id );
        x.setAge( age );
        x.setCpuSize( cupSize );
        return girlRepository.save( x );
    }

//    @GetMapping(value = "/girls/{id}")
//    public void delOneGirl(@PathVariable("id") Integer id) {
//        girlRepository.deleteById( id );
//    }
}