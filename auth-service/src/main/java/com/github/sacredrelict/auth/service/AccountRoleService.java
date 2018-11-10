package com.github.sacredrelict.auth.service;

import com.github.sacredrelict.auth.domain.AccountRole;

import java.util.List;

/**
 * Service layer interface for AccountRole.
 */
public interface AccountRoleService {

    AccountRole getById(Long id);

    List<AccountRole> getRolesByAccountId(Long accountId);

}
