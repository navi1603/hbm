package dao;

import entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDAO {

    void add(Project project) throws SQLException;

    List<Project> getAll() throws SQLException;

    Project getById(Long id)throws SQLException;

    void update(Project project) throws SQLException;

    void delete (Project project) throws SQLException;

}
