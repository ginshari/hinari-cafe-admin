"use strict";

const xhr = new XMLHttpRequest();
const getVideoDataButton = document.getElementById("getVideoData");
getVideoDataButton.addEventListener("click", (e) => {
  xhr.open(
    "GET",
    "/video?videoId=" + document.getElementById("videoId").value,
    true
  );
  xhr.send();
  xhr.addEventListener("load", function () {
    if (this.readyState === 4 && this.status === 200) {
      const videoData = JSON.parse(xhr.responseText);
      document.getElementById("pubDate").value = videoData.pubDate;
      document.getElementById("videoTitle").value = videoData.videoTitle;
      document.getElementById("imgUrl").value = videoData.imgUrl;
    }
  });
});
