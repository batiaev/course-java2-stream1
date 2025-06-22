package com.batiaev.patterns.lesson3;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private final String name;
    private final Person owner;
    private final List<Asset> assets;

    @java.beans.ConstructorProperties({"name", "owner", "assets"})
    Account(String name, Person owner, List<Asset> assets) {
        this.name = name;
        this.owner = owner;
        this.assets = assets;
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder {
        private String name;
        private Person owner;
        private List<Asset> assets;

        AccountBuilder() {
        }

        public AccountBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AccountBuilder owner(Person owner) {
            this.owner = owner;
            return this;
        }

        public AccountBuilder assets(List<Asset> assets) {
            this.assets = assets;
            return this;
        }

        public Account build() {
            return new Account(name, owner, assets);
        }

        public String toString() {
            return "Account.AccountBuilder(name=" + this.name + ", owner=" + this.owner + ", assets=" + this.assets + ")";
        }

        public AccountBuilder addAsset(Asset rub) {
            if (assets == null) assets = new ArrayList<Asset>();
            assets.add(rub);
            return this;
        }
    }
}
