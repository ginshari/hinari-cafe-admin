package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("profiles")
@Data
public class Profile {

    @Id
    private String id;

    private int order;

    private String head;

    private String body;

}
