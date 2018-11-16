package com.music.sharespace.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Principal;

@Controller
@RequestMapping("/download")
public class DownloadController {

    private Logger logger = LogManager.getLogger(DownloadController.class);

    @Value("${fileLocation}")
    private String fileLocation;

    @RequestMapping(value="/{fileName}", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(HttpServletResponse response, @PathVariable String fileName, Principal principal) throws IOException {
         try {
             File file = new File(fileLocation + principal.getName() + "/" + fileName);
             response.setContentLength((int) file.length());
             String mimeType = "application/octet-stream";
             response.setContentType(mimeType);
             InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

             //Copy bytes from source to destination(outputstream in this example), closes both streams.
             FileCopyUtils.copy(inputStream, response.getOutputStream());
         }catch(IOException io){
             logger.error(new IOException(io));
             throw new IOException(io);
         }
    }

}
