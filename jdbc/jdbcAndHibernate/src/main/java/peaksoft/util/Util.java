package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД

    public static SessionFactory getSession(){




        Properties properties = new Properties();
        properties.put(Environment.DRIVER,"org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate_task2");
        properties.put(Environment.USER,"postgres");
        properties.put(Environment.PASS,"postgres");
        properties.put(Environment.HBM2DDL_AUTO,"update");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL,"true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }
}
