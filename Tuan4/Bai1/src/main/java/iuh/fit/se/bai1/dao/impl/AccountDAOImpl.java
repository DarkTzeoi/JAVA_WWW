package iuh.fit.se.bai1.dao.impl;

import iuh.fit.se.bai1.dao.AccountDAO;
import iuh.fit.se.bai1.enity.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private final DataSource dataSource;

    public AccountDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Account> findAll() {
        String sql = "SELECT firstName, lastName, email, password, birthDay, gender from accountdb";
        List<Account> listAccount = new ArrayList<>();
        try (
                Connection con = (Connection) this.dataSource.getConnection();
                PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                ){

        } catch (SQLException e){
            e.printStackTrace();
        }
        return listAccount;
    }

    @Override
    public boolean addAccount() {
        return false;
    }
}
