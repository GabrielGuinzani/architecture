package com.satc.architecture.subscription.concrete;

import com.satc.architecture.subscription.SubscriptionEntity;
import com.satc.architecture.subscription.behavior.ICancelBehavior;
import com.satc.architecture.subscription.behavior.IRenewBehavior;

public class TryBuy extends SubscriptionEntity implements IRenewBehavior {

    public TryBuy(SubscriptionEntity subscription){
        super(subscription);
    }
    @Override
    public void performRenew(){
        this.renewBehavior();
    }

    @Override
    public void renewBehavior(){
        this.cancelBehavior();
    };
}
