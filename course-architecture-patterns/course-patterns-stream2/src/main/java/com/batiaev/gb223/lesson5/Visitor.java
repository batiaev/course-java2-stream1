package com.batiaev.gb223.lesson5;

import com.batiaev.gb223.BankCard;

/**
 * Visitor
 *
 * @author anton
 * @since 30/07/19
 */
public interface Visitor {
    void visit(BankCard card);
}
