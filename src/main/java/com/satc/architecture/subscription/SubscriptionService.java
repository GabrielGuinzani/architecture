package com.satc.architecture.subscription;

import com.satc.architecture.account.AccountEntity;
import com.satc.architecture.account.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private AccountRepository accountRepository;

    public void createNewSubscription(SubscriptionRepresentation.CreateSubscription createSubscription){


        AccountEntity account = this.accountRepository.findAllById(createSubscription.account.get());

        if(account.isPresent())

        SubscriptionEntity newSub = new SubscriptionEntity(SubscriptionRepresentation.CreateSubscription)

    };

}
