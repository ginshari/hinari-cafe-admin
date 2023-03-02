# hinari-cafe-admin
hinari-cafe-nuxt3の管理画面です

## Architecture

| Main Framework | UI Framework | DataBase |
| --- | --- | --- | ---|
| SpringBoot3 | Bootstrap5 | MongoDB Atlas |

## Setup

Create src/main/resources/application.properties file:

```
spring.data.mongodb.uri=YOUR_ATLAS_URI
spring.data.mongodb.database=YOUR_ATLAS_DATABASE
spring.thymeleaf.prefix=classpath:/templates/
youtube.apikey=YOUR_YOUTUBE_DATA_API_KEY
```
