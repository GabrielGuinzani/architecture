package com.satc.architecture.subscription.concrete;

import com.satc.architecture.subscription.SubscriptionEntity;
import com.satc.architecture.subscription.behavior.IRenewBehavior;

public class Sales extends SubscriptionEntity implements IRenewBehavior {
    public Sales(SubscriptionEntity subscription){
        super(subscription);
    }

    @Override
    public void performRenew(){
        this.renewBehavior();
    }

    @Override
    public void renewBehavior(){
        //todo
    };

    @Override
    public void performCharge(){
        this.chargeBehavior();
    }
    @Override
    public void chargeBehavior(){
        //Todo o código

    };
}
