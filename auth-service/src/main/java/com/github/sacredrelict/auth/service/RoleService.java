package com.github.sacredrelict.auth.service;

import com.github.sacredrelict.auth.domain.Role;

/**
 * Service layer interface for Role.
 */
public interface RoleService {

    Role getById(Long id);

}
