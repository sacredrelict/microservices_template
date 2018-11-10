package com.github.sacredrelict.auth.service;

import com.github.sacredrelict.auth.domain.Account;

/**
 * Service layer interface for Account.
 */
public interface AccountService {

    Account getById(Long id);

    Account getByLogin(String login);

}
