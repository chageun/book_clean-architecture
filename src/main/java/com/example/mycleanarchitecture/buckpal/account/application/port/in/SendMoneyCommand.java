package com.example.mycleanarchitecture.buckpal.account.application.port.in;

import com.example.mycleanarchitecture.buckpal.account.domain.Account.AccountId;
import com.example.mycleanarchitecture.buckpal.account.domain.Money;
import com.example.mycleanarchitecture.buckpal.common.SelfValidating;
import lombok.Getter;

import javax.validation.constraints.NotNull;


@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {
    @NotNull
    private final AccountId sourceAccountId;
    @NotNull
    private final AccountId targetAccountId;
    @NotNull
    private final Money money;

    public SendMoneyCommand(AccountId  sourceAccountId, AccountId targetAccountId,Money money){
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }
}
