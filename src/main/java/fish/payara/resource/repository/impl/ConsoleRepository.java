package fish.payara.resource.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fish.payara.resource.config.PostgresConfig;
import fish.payara.resource.model.Console;
import fish.payara.resource.repository.IConsoleRepository;
import fish.payara.resource.repository.exception.DatabaseException;

public class ConsoleRepository implements IConsoleRepository {

    @Override
    public List<Console> findAllConsoles() {
        List<Console> consoles = new ArrayList<>();
        try (Connection conn = PostgresConfig.getConnection()) {
            String query = "SELECT * FROM console ORDER BY name";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Console console = new Console();
                        console.setId(rs.getLong("id"));
                        console.setName(rs.getString("name"));
                        console.setCompany(rs.getString("company"));
                        console.setReleaseDate(rs.getDate("release_date").toLocalDate());
                        console.setImageUrl(rs.getString("image_url"));
                        console.setCreateAt(rs.getTimestamp("create_at").toLocalDateTime());
                        console.setUpdateAt(rs.getTimestamp("update_at").toLocalDateTime());
                        consoles.add(console);
                    }
                }
            }
            return consoles;

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao executar a Query!: " + e.getMessage());
        }
    }

    @Override
    public Optional<Console> findById(long id) {
        final String query = "SELECT * FROM console WHERE id = ?";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setLong(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Console console = new Console();
                        console.setId(rs.getLong("id"));
                        console.setName(rs.getString("name"));
                        console.setCompany(rs.getString("company"));
                        console.setReleaseDate(rs.getDate("release_date").toLocalDate());
                        console.setImageUrl(rs.getString("image_url"));
                        console.setCreateAt(rs.getTimestamp("create_at").toLocalDateTime());
                        console.setUpdateAt(rs.getTimestamp("update_at").toLocalDateTime());
                        return Optional.of(console);
                    } else {
                        return Optional.empty();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao encontrar console por ID: " + e.getMessage());
            throw new DatabaseException("Erro ao encontrar console por ID!: " + e);
        }
    }

}
