"use strict";

// 動画メタデータ取得
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

// hh:mm:ss形式の文字列を秒数に変換
function convertTimeToSeconds(time) {
  let timeArray = time.split(":");
  // mm:ssであればhhを00とする
  if (timeArray.length !== 3) {
    timeArray = ["00", ...timeArray];
  }
  const [hh, mm, ss] = timeArray.map((str) => parseInt(str));
  return hh * 60 * 60 + mm * 60 + ss;
}
const orderTimeInput = document.getElementById("orderTimeInput");
const orderTime = document.getElementById("orderTime");
const reviewTimeInput = document.getElementById("reviewTimeInput");
const reviewTime = document.getElementById("reviewTime");
orderTimeInput.addEventListener("change", (e) => {
  orderTime.value = convertTimeToSeconds(e.target.value);
});
reviewTimeInput.addEventListener("change", (e) => {
  reviewTime.value = convertTimeToSeconds(e.target.value);
});
