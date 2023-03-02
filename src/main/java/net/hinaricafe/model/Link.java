package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("links")
@Data
public class Link {

    @Id
    private String id;
    
    private int order;

    private String text;

    private String url;

}
