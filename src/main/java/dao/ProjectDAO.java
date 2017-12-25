package dao;

import model.Project;

import java.sql.SQLException;

public interface ProjectDAO extends GenericDAO<Project, Integer> {
    public int getColumnSize(String column) throws SQLException;

    }
