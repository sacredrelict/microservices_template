package com.github.sacredrelict.data.service;

import com.github.sacredrelict.data.entity.Account;

import java.util.List;

/**
 * Service layer interface for Account.
 */
public interface AccountService {

    Account getById(Long id);

    Account getByLogin(String login);

    List<Account> getAll();

    Account save(Account account);

    void delete(Long id);

}
