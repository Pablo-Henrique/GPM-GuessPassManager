package com.happysy.gpc.repository;

import com.happysy.gpc.model.TicketPass;
import com.happysy.gpc.util.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TickerPassRepositoryImpl implements TicketPassRepository {

    @Override
    public TicketPass insert(TicketPass ticket) {
        String sql = "INSERT INTO TicketPass (id, pass, sector, loja) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = JDBConnection.getConnection().prepareStatement(sql)) {
            statement.setLong(1, 1);
            statement.setString(2, ticket.getSenha());
            statement.setString(3, ticket.getSetor());
            statement.setString(4, ticket.getLoja());

            int lines = statement.executeUpdate();

            if (lines == 0) {
                System.out.println("inserido com sucesso");
            } else {
                System.out.println("Erro ao inserir");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ticket;
    }

    @Override
    public boolean update(TicketPass ticket) {
        return false;
    }

    @Override
    public boolean updateById(Integer ticketID) {
        return false;
    }

    @Override
    public String findPassById(Integer ticketById) {
        String sqlFindPassById = "SELECT senha FROM TicketPass WHERE id = ?";
        try (PreparedStatement statement = JDBConnection.getConnection().prepareStatement(sqlFindPassById)){
            statement.setInt(1, ticketById);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("senha");
            }else {
                return  "Não foi possivel localizar o ID";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updatePassById(Integer ticketID, String newPass) {
        String sqlUpdatePassById = "UPDATE TicketPass SET senha = ? WHERE id = ?";
        try (PreparedStatement statement = JDBConnection.getConnection().prepareStatement(sqlUpdatePassById)) {
            statement.setString(1, newPass);
            statement.setInt(2, ticketID);

            int lines = statement.executeUpdate();

            if (lines > 0) {
                System.out.println("Dados Atualizados com sucesso");
                return true;
            }else {
                System.out.println("Ocorreu um problema em atualizar os dados");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TicketPass remove(TicketPass ticket) {
        return null;
    }

    public List<TicketPass> findAll() {
        String sqlFindAll = "SELECT * FROM TicketPass";
        try (PreparedStatement statement = JDBConnection.getConnection().prepareStatement(sqlFindAll)) {
            ResultSet resultSet = statement.executeQuery();

            List<TicketPass> ticketPassList = new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String pass = resultSet.getString("pass");
                String setor = resultSet.getString("sector");
                String loja = resultSet.getString("loja");
                ticketPassList.add(new TicketPass(id, pass, setor, loja));
            }
            return ticketPassList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TicketPass findTicketPassById(Integer ticketById) {
        String sqlFindById = "SELECT * FROM TicketPass WHERE id = ?";
        try (PreparedStatement statement = JDBConnection.getConnection().prepareStatement(sqlFindById)) {
            statement.setInt(1, ticketById);
            ResultSet resultSet = statement.executeQuery();

            TicketPass ticketPass = new TicketPass();

            if (resultSet.next()) {
                ticketPass.setId(resultSet.getInt("id"));
                ticketPass.setSenha(resultSet.getString("senha"));
                ticketPass.setSetor(resultSet.getString("setor"));
                ticketPass.setSetor(resultSet.getString("loja"));
            } else {
                System.out.println("TickerPass Não Encontrado");
            }
            return ticketPass;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
