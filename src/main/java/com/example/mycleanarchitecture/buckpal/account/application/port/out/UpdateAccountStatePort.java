package com.example.mycleanarchitecture.buckpal.account.application.port.out;

import com.example.mycleanarchitecture.buckpal.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
