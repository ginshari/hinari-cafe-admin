package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("events")
@Data
public class Event {

    @Id
    private String id;

    private String yyyymm;

    private int branchNumber;

    private String category;

    private String name;

    private String url;

}
