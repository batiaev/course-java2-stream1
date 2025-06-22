package com.batiaev.patterns.lesson5;

public class TransactionService {
    private ServiceDiscovery serviceDiscovery;

    public TransactionService(ServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    public void transfer(String from, String to, double amount) {
        final CommissionService commissionService = serviceDiscovery.getCommissionService();
        doTransfer(from, to, amount - commissionService.calcCommission());
    }

    private void doTransfer(String from, String to, double amount) {
        System.out.println("Tranfer from " + from + " to " + to);
    }
}
