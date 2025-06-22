package com.batiaev.patterns.lesson5;

public class ServiceDiscovery {
    public CommissionService getCommissionService() {
        return new CommissionService();
    }
}
