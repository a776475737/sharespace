package com.music.sharespace.controller;

import com.music.sharespace.domain.TrackInfo;
import com.music.sharespace.service.filedirectory.FileDirectorySearchService;
import com.music.sharespace.service.user.UserSearchService;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class IndexController {

    @Value("${fileLocation}")
    private String fileLocation;

    @Autowired
    private FileDirectorySearchService fileDirectorySearchService;

    @Autowired
    private UserSearchService userSearchService;

    @RequestMapping
    @ResponseBody
    public ModelAndView returnHome(Principal principal) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        List<TrackInfo> trackInfoList = new ArrayList<>();
        fileDirectorySearchService.clearUsedSearchedList();
        trackInfoList.addAll(fileDirectorySearchService.fetchUserFiles(principal.getName()));
        List<TrackInfo> globalTrackList = fetchOtherTrackInfo();
        modelAndView.setViewName("index");
        modelAndView.addObject("user", principal.getName());
        modelAndView.addObject("trackInfoList", trackInfoList);
        modelAndView.addObject("globalTrackInfoList", globalTrackList);
        return modelAndView;
    }

    private List<TrackInfo> fetchOtherTrackInfo() throws ReadOnlyFileException, IOException, TagException, InvalidAudioFrameException, CannotReadException {
        List<String> userList = userSearchService.fetchUsers();
        List<TrackInfo> trackInfoList = new ArrayList<>();
        for(String user: userList) {
            trackInfoList.addAll(fileDirectorySearchService.fetchUserFiles(user));
        }
        return trackInfoList;
    }

}
