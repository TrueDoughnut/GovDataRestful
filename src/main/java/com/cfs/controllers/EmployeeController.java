package com.cfs.controllers;

import com.cfs.general.Record;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController extends Controller {

    private static final String tag = "/employee";
    public static List<Record> list;

    @RequestMapping(value = tag + "/id")
    public Object getEmployee(@RequestParam(value="id", required = false, defaultValue = "0") int id){
        return list.get(id).run();
    }

    @RequestMapping(value = tag + "/search")
    public Object search(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "search") String search){
        return super.search(key, search);
    }
}
