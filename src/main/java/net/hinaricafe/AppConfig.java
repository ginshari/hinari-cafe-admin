package net.hinaricafe;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "youtube")
@Data
public class AppConfig {
    public String apikey;
}
