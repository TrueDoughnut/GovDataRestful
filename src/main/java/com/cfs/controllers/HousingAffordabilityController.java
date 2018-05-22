package com.cfs.controllers;

import com.cfs.general.Record;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HousingAffordabilityController extends Controller {

    public static final String tag = "/HousingAffordability";
    public static List<Record> list;

    public HousingAffordabilityController(){
        super.list = list;
    }

    @RequestMapping(value = tag + "/id")
    public Object getHousingAffordability(
            @RequestParam(value = "id", required = false, defaultValue = "0") int id){
        return list.get(id).run();
    }
    @RequestMapping(value = tag + "/search")
    public Object search(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "search") String search){
        return super.search(key, search);
    }


}
