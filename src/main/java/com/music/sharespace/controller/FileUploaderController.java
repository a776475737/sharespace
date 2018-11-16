package com.music.sharespace.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class FileUploaderController {

    private Logger logger = LogManager.getLogger(FileUploaderController.class);

    @Value("${fileLocation}")
    private String fileLocation;

    @PostMapping()
    public String uploadFile(@RequestParam("files") List<MultipartFile> files,
                             RedirectAttributes redirectAttributes, Principal principal) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        try {
            for(MultipartFile file: files) {
                File fileStore = new File(fileLocation + principal.getName() + "/" + file.getOriginalFilename().replace(" ", "_"));
                fileStore.createNewFile();
                OutputStream outputStream = new FileOutputStream(fileStore);
                outputStream.write(file.getBytes(), 0, (int) file.getSize());
                outputStream.close();
            }
        }catch(IOException io){
            logger.error(new IOException(io));
            throw new IOException(io);
        }
        return "redirect:/";
    }

}
