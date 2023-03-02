package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("landingPage")
@Data
public class LandingPage {

    @Id
    private String id;

    private String greeting;

    private String annotation;

    @DBRef
    private List<LpItem> works;

    @DBRef
    private List<LpItem> recommends;

    @DBRef
    private List<LpItem> coffees;

}
