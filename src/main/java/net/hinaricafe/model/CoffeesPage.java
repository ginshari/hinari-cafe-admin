package net.hinaricafe.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("coffeesPage")
@Data
public class CoffeesPage {

    @Id
    private String id;

    private List<Coffee> coffees;

}
