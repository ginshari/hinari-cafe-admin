package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("worksPage")
@Data
public class WorksPage {

    @Id
    private String id;
    
    @DBRef
    private List<Link> links;

    @DBRef
    private List<Event> events;

    @DBRef
    private List<Profile> profiles;

}
