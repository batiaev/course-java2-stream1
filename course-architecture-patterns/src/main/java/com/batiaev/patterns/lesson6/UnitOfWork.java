package com.batiaev.patterns.lesson6;

import java.io.Serializable;
import java.util.List;

public class UnitOfWork<T extends Serializable> {
    private List<T> newInstances;
    private List<T> updatedInstances;
    private List<T> deletedInstances;

    public void  commit() {
        updatedInstances.forEach(this::update);
        fetch();
        deletedInstances.forEach(this::delete);
        newInstances.forEach(this::save);
    }

    private void save(T t) {
        //FIXME
    }

    private void delete(T t) {
        //FIXME
    }

    private void fetch() {
        //FIXME
    }

    private void update(T t) {
        //FIXME
    }
}
