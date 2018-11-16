package com.music.sharespace.service.filedirectory;

import com.music.sharespace.domain.TrackInfo;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileDirectorySearchService {

    @Value("${fileLocation}")
    private String fileLocation;

    private List<String> usersSearched = new ArrayList<>();

    public File[] fetchAllDirectories(){
        File file = new File(fileLocation);
        return file.listFiles();
    }

    public void clearUsedSearchedList(){
        usersSearched = new ArrayList<>();
    }

    public List<TrackInfo> fetchUserFiles(String username) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        List<TrackInfo> trackInfoList = new ArrayList<>();
        if(!usersSearched.contains(username)) {
            usersSearched.add(username);
            String userFileLocation = fileLocation + username;
            File uploadedFiles = new File(userFileLocation);
            File[] fileList = uploadedFiles.listFiles();
            if (fileList != null) {
                for (final File fileEntry : uploadedFiles.listFiles()) {
                    TrackInfo trackInfo = new TrackInfo();
                    AudioFile f = AudioFileIO.read(fileEntry);
                    Tag tag = f.getTag();
                    trackInfo.setGenre(tag.getAll(FieldKey.GENRE).get(0));
                    trackInfo.setArtists(tag.getAll(FieldKey.ARTIST));
                    trackInfo.setAlbum(tag.getAll(FieldKey.ALBUM).get(0));
                    trackInfo.setSong(tag.getAll(FieldKey.TITLE).get(0));
                    trackInfo.setTrackFile(fileEntry);
                    trackInfo.setUploader(userFileLocation.substring(userFileLocation.indexOf("music") + "music".length() + 1));
                    trackInfoList.add(trackInfo);
                }
            }
        }
        return trackInfoList;
    }

}
