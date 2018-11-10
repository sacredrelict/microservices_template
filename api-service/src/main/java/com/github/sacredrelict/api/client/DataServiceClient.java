package com.github.sacredrelict.api.client;

import com.github.sacredrelict.api.config.FeignClientConfiguration;
import com.github.sacredrelict.api.dto.Account;
import com.github.sacredrelict.api.dto.AccountRole;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign client to communicate with Data Service.
 */
@FeignClient(value = "data-service", configuration = {FeignClientConfiguration.class})
@RequestMapping(value = "data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface DataServiceClient {

    /**
     * AccountController:
     */
    @RequestMapping(path = "/account", method = RequestMethod.POST)
    ResponseEntity<Account> createAccount(@RequestBody Account account);

    @RequestMapping(path = "/account", method = RequestMethod.PUT)
    ResponseEntity<Account> updateAccount(@RequestBody Account account);

    @RequestMapping(path = "/account", method = RequestMethod.DELETE)
    void deleteAccount(@RequestParam(value = "id") Long id);

    @RequestMapping(path = "/account/all", method = RequestMethod.GET)
    List<Account> findAllAccounts();

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    Account findAccountById(@RequestParam(value = "id", required = true) Long id);

    @RequestMapping(path = "/account/login", method = RequestMethod.GET)
    Account findAccountByLogin(@RequestParam(value = "login", required = true) String login);

    @RequestMapping(path = "/account/all/company", method = RequestMethod.GET)
    List<Account> findAccountsByCompany(@RequestParam(value = "id", required = true) Long id);

    @RequestMapping(path = "/account/role", method = RequestMethod.GET)
    List<AccountRole> findByAccountId(@RequestParam(value = "id", required = true) Long id);

}
