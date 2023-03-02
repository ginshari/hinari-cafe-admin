package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("lpItems")
@Data
public class LpItem {

    @Id
    private String id;

    private String category;

    private int order;

    private String url;

    private String imgUrl;

    private String head;

    private String body;

}
