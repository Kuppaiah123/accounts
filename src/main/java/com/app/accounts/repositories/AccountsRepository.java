package com.app.accounts.repositories;

import com.app.accounts.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts findAccountsByCustomerId(int customerId);
}
