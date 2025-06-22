package com.batiaev.gb223;

/**
 * Proxy
 *
 * @author anton
 * @since 23/07/19
 */
public class Proxy implements Acccount {

    private final Control control;
    private final Acccount account;

    public static Acccount proxy(Acccount acccount) {
        Control control = () -> {};
        return new Proxy(control, acccount);
    }
    public Proxy(Control control, Acccount account) {
        this.control = control;
        this.account = account;
    }

    @Override
    public double getAmount() {
        control.control();
        return account.getAmount();
    }

    @Override
    public void setAmount(double value) {
        control.control();
        account.setAmount(value);
    }
}
