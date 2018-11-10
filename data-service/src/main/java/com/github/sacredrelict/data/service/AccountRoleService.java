package com.github.sacredrelict.data.service;

import com.github.sacredrelict.data.entity.AccountRole;

import java.util.List;

/**
 * Service layer interface for AccountRole.
 */
public interface AccountRoleService {

    AccountRole getById(Long id);

    List<AccountRole> getRolesByAccountId(Long accountId);

}
