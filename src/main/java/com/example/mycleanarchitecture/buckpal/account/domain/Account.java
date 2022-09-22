package com.example.mycleanarchitecture.buckpal.account.domain;


import lombok.Value;

import java.time.LocalDateTime;

public class Account {
    private AccountId id;
    private Money baselineBalance;
    private ActivityWindow activityWindow;
    /**
     * 계좌 잔액 계산
     * 계좌 잔액 = baselineBalance + activityWindow에 있는 activity
     * */
    public Money calculateBalance(){
        return Money.add(this.baselineBalance,this.activityWindow.calculateBalance(this.id));
    }
    /**
     * 계좌 인출
     * 1. 인출 가능 여부 확인
     * 2. activityWindow에 Withdrawal Activity 추가
     * */
    public boolean withdraw(Money money, AccountId targetAccountId){
        if(!mayWithdraw(money)){
            return false;
        }
        Activity withdrawal = new Activity(this.id,this.id,targetAccountId, LocalDateTime.now(),money);
        this.activityWindow.addActivity(withdrawal);
        return true;
    }
    /**
     * 입금
     * : ActivityWindow 에 추가
     * */
    public boolean deposit(Money money, AccountId sourceAccountId) {
        Activity deposit = new Activity(
            this.id,
            sourceAccountId,
            this.id,
            LocalDateTime.now(),
            money);
        this.activityWindow.addActivity(deposit);
        return true;
    }
    /**
     * 출금 가능 금액인지 확인
     * */
    private boolean mayWithdraw(Money money){
        return Money.add(this.calculateBalance(),money.negate()).isPositiveOrZero();
    }

    @Value
    public static class AccountId {
        private Long value;
    }

}
