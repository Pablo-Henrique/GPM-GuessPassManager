package com.happysy.gpc.repository;

import com.happysy.gpc.model.TicketPass;
import com.happysy.gpc.util.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TickerPassRepositoryImpl implements TicketPassRepository {

    @Override
    public boolean insert(TicketPass o) {
        String sql = "INSERT INTO TicketPass (id, pass, sector, hora, datas) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = JDBConnection.getConnection().prepareStatement(sql)){
            statement.setLong(1, 1);
            statement.setString(2, o.getPass());
            statement.setString(3, "Frios");
            statement.setString(4, o.getHours());
            statement.setString(5, o.getDate());

            int lines = statement.executeUpdate();

            if (lines < 0) {
                System.out.println("inserido com sucesso");
            }else {
                System.out.println("Erro ao inserir");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean find(Object o) {
        return false;
    }
}
