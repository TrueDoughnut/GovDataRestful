package com.cfs.controllers;

import com.cfs.general.Record;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Controller {

    public List<Record> list;

    public boolean isHeader(String key){
        return list.get(0).data.containsKey(key);
    }

    public Object search(String key, String search){
        if(isHeader(key)) {
            if (search.contains(" ")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).data.get(key).equalsIgnoreCase(search)) {
                        return list.get(i).run();
                    }
                }
            } else {
                for(int i = 0; i < list.size(); i++){
                    for(String str : list.get(i).data.get(key).split(" ")){
                        if(str.equalsIgnoreCase(search)){
                            return list.get(i).run();
                        }
                    }
                }
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
