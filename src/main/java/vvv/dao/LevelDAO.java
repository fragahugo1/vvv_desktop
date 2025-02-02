package main.java.vvv.dao;

import main.java.vvv.model.Level;
import main.java.vvv.dao.ConnectionMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LevelDAO {

    public List<Level> listarLevel() {
        List<Level> levels = new ArrayList<>();
        String sql = "SELECT id, tipo FROM level";
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionMVC().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Level level = new Level();
                level.setId(rs.getInt("id"));
                level.setTipo(rs.getString("tipo"));
                levels.add(level);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return levels;
    }
}
