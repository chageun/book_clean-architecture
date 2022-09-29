package com.example.mycleanarchitecture.buckpal.account.application.port.out;

import com.example.mycleanarchitecture.buckpal.account.domain.Account;

public interface AccountLock {
    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
