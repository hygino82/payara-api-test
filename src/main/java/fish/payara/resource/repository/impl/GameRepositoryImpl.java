package fish.payara.resource.repository.impl;

import fish.payara.resource.config.PostgresConfig;
import fish.payara.resource.model.Game;
import fish.payara.resource.repository.IGameRepository;
import fish.payara.resource.repository.exception.DatabaseException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GameRepositoryImpl implements IGameRepository {

    @Override
    public List<Game> findAllGames() {
        List<Game> gamelist = new ArrayList<>();
        try (Connection conn = PostgresConfig.getConnection()) {
            String query = "SELECT * FROM game ORDER BY name ASC";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Game game = new Game();
                        game.setId(rs.getLong("id"));
                        game.setName(rs.getString("name"));
                        game.setPublisher(rs.getString("publisher"));
                        game.setReleaseDate(rs.getDate("release_date").toLocalDate());
                        game.setImageUrl(rs.getString("image_url"));
                        game.setCreateAt(rs.getTimestamp("create_at").toLocalDateTime());
                        game.setUpdateAt(rs.getTimestamp("update_at").toLocalDateTime());
                        gamelist.add(game);
                    }
                }
            }
            return gamelist;

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao executar a Query!: " + e.getMessage());
        }
    }

    @Override
    public Optional<Game> findGameById(long id) {
        final String query = "SELECT * FROM game WHERE id = ?";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setLong(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Game game = new Game();
                        game.setId(rs.getLong("id"));
                        game.setName(rs.getString("name"));
                        game.setPublisher(rs.getString("publisher"));
                        game.setReleaseDate(rs.getDate("release_date").toLocalDate());
                        game.setImageUrl(rs.getString("image_url"));
                        game.setCreateAt(rs.getTimestamp("create_at").toLocalDateTime());
                        game.setUpdateAt(rs.getTimestamp("update_at").toLocalDateTime());
                        return Optional.of(game);
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

    @Override
    public Game updateGame(long id, Game entity) {
        final String query = "UPDATE game SET name = ?, publisher = ?, release_date = ?, image_url = ?, create_at = ?  WHERE id = ?";
        entity.setUpdateAt(LocalDateTime.now());
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, entity.getName());
                stmt.setString(2, entity.getPublisher());
                stmt.setDate(3, java.sql.Date.valueOf(entity.getReleaseDate()));
                stmt.setString(4, entity.getImageUrl());
                stmt.setTimestamp(5, java.sql.Timestamp.valueOf(entity.getUpdateAt()));
                stmt.setLong(6, id);
                stmt.executeUpdate();
                return entity;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar console: " + e.getMessage());
            throw new DatabaseException("Erro ao atualizar console!: " + e);
        }
    }

    @Override
    public Game insertGame(Game entity) {
        final String query = "INSERT INTO game (name, publisher, release_date, image_url, create_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, entity.getName());
                stmt.setString(2, entity.getPublisher());
                stmt.setDate(3, java.sql.Date.valueOf(entity.getReleaseDate()));
                stmt.setString(4, entity.getImageUrl());
                stmt.setTimestamp(5, java.sql.Timestamp.valueOf(entity.getCreateAt()));
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setId(rs.getLong("id"));
                    }
                }
                return entity;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir console: " + e.getMessage());
            throw new DatabaseException("Erro ao inserir console!: " + e);
        }
    }

    @Override
    public boolean removeGame(long id) {
        final String query = "DELETE FROM game WHERE id = ?";
        try (Connection conn = PostgresConfig.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setLong(1, id);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected != 0;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover console por ID: " + e.getMessage());
            throw new DatabaseException("Erro ao remover console por ID!: " + e);
        }
    }
}
