package main.java.vvv.controller;

import main.java.vvv.dao.LevelDAO;
import main.java.vvv.model.Level;

import java.util.List;

public class LevelController {

    private final LevelDAO levelDAO;

    public LevelController() {
        this.levelDAO = new LevelDAO();
    }

    public List<Level> listarLevel() {
        try {
            return levelDAO.listarLevel();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
