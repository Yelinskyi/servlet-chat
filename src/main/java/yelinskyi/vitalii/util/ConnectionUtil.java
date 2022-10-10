package yelinskyi.vitalii.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class ConnectionUtil {
    private static final Properties dbProperties = PropertiesUtil.getProperties();

    static {
        try {
            Class.forName(dbProperties.getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            log.error("Can't find SQL Driver", e);
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    dbProperties.getProperty("db.url"),
                    dbProperties.getProperty("db.username"),
                    dbProperties.getProperty("db.password")
            );
        } catch (SQLException e) {
            log.error("Can't create connection to DB ", e);
            throw new RuntimeException("Can't create connection to DB ", e);
        }
    }

}
