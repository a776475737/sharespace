package com.music.sharespace.service.filedirectory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileDirectoryCreateService {

    @Value("${fileLocation}")
    private String fileLocation;

    public boolean createFileDirectoryForUser(String username){
        return new File(fileLocation + username).mkdir();
    }

}
