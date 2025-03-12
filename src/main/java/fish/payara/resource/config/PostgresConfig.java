package fish.payara.resource.config;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class PostgresConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/gamelist";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "89631139";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        }
    }

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(URL);
        ds.setUsername(USUARIO);
        ds.setPassword(SENHA);
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}