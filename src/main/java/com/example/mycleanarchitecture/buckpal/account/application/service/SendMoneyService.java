package com.example.mycleanarchitecture.buckpal.account.application.service;

import com.example.mycleanarchitecture.buckpal.account.application.port.in.SendMoneyUseCase;
import com.example.mycleanarchitecture.buckpal.account.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

}
