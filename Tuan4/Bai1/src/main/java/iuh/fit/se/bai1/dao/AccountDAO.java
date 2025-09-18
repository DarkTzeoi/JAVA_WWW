package iuh.fit.se.bai1.dao;

import iuh.fit.se.bai1.enity.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAll();
    boolean addAccount();
}
