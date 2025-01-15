package com.robb.personalblog.Service;


import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DeleteService {

    public boolean delete(String title){
        String filePath = "src/main/resources/articles/" + title.replace(" ", "").toLowerCase() + ".json";
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
            return true;
        } else {
            System.out.println("File does not exist");
            return false;
        }
    }
}
