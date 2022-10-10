package yelinskyi.vitalii.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class PropertiesUtil {

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            log.error("Incorrect config.properties ", e);
            throw new RuntimeException("Incorrect config.properties ", e);
        }
        return properties;
    }

}
