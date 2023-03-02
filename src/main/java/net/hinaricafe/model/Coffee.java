package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("coffees")
@Data
public class Coffee {

    @Id
    private String id;

    private String videoId;

    private String pubDate;

    private String videoTitle;
    
    private String imgUrl;

    private String name;

    private String orderTime;

    private String reviewTime;

    private String reviewText;

    private String note;

}
