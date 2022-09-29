package com.example.mycleanarchitecture.buckpal.account.application.port.in;

import com.example.mycleanarchitecture.buckpal.account.domain.Account.AccountId;
import com.example.mycleanarchitecture.buckpal.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(AccountId accountId);

}
