package net.hinaricafe.service;

import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;
import lombok.RequiredArgsConstructor;
import net.hinaricafe.AppConfig;
import net.hinaricafe.common.MyYouTube;
import net.hinaricafe.model.MyVideo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@RequiredArgsConstructor
public class YouTubeService {

    private final AppConfig appConfig;

    private final MyYouTube myYouTube;

    public MyVideo getVideoData(String videoId) {

        try {

            YouTube.Videos.List videosListApi = myYouTube.videos().list("id,snippet");

            videosListApi.setKey(appConfig.apikey);
            videosListApi.setId(videoId);
            videosListApi.setFields("items(id,snippet/publishedAt,snippet/title,snippet/thumbnails/medium/url)");

            VideoListResponse videoListResponse = videosListApi.execute();

            List<Video> myVideoItems = videoListResponse.getItems();

            if (myVideoItems != null && myVideoItems.size() > 0) {
                Video video = myVideoItems.get(0);

                var myVideo = new MyVideo();
                myVideo.setVideoId(video.getId());
                myVideo.setVideoTitle(video.getSnippet().getTitle());
                myVideo.setPubDate(dateTimeToString(video.getSnippet().getPublishedAt()));
                myVideo.setImgUrl(video.getSnippet().getThumbnails().getMedium().getUrl());

                return myVideo;
            }

        } catch (Exception e) {
            System.err.println("YOUTUBE DATA API ERROR : " + e.getMessage());
        }

        return new MyVideo();
    }

    // com.google.api.client.util.DateTimeをローカルのuuuu-MM-dd形式文字列に変換する
    private String dateTimeToString(DateTime dateTime) {

        // googleのDateTimeはgetValueでエポック秒を返す
        Instant instant = Instant.ofEpochMilli(dateTime.getValue());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");

        return localDateTime.format(formatter);
    }

}
