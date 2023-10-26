package com.satc.architecture.subscription;

public interface ISubscription {

    void performSubscription(Long idAccount, Plan plan );
    void performRenew();
    void performCancel();
    void performCharge();


}
