package com.sterefine.energetic.bean.controller;

import com.sterefine.energetic.bean.config.ThirdLibClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author sterefine
 */
@RestController
@RequestMapping("/bean")
@Slf4j
public class BeanHttpController {
    @Autowired
    ThirdLibClass thirdLibClass;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
        return thirdLibClass.getField1() + " " + thirdLibClass.getField2();
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public ResponseEntity<String> test2(@RequestParam("a") String a){
        return new ResponseEntity<String>("the input is " + a, HttpStatus.OK);
    }
}
