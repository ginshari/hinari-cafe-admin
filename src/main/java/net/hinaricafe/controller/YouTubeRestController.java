package net.hinaricafe.controller;

import lombok.RequiredArgsConstructor;
import net.hinaricafe.model.MyVideo;
import net.hinaricafe.service.YouTubeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class YouTubeRestController {

    private final YouTubeService youTubeService;

    @GetMapping("/video")
    public MyVideo getVideoData(@RequestParam("videoId") String videoId) {
        return youTubeService.getVideoData(videoId);
    }
}

