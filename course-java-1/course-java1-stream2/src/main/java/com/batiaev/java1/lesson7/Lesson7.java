package com.batiaev.java1.lesson7;

/**
 * Lesson7
 *
 * @author anton
 * @since 12/02/18
 */
public class Lesson7 {

    public static void main(String[] args) {
//        firstExample();
//        catExample();
        bankExample();
    }

    private static void bankExample() {
        Human anton = new Human();
        Company richCompany = new Company();

        BankCard bankCard = richCompany.getBankCard();

        anton.setBankCards(0, bankCard);
        anton.setBankCards(1, new BankCard("bank1", 150));
        anton.setBankCards(2, new BankCard("bank2", 200));

        transaction(anton.getBankCardById(2),
                anton.getBankCardById(0),
                100);

        richCompany.paySalary(1000000);


        BankCard bankCard1 = richCompany.getBankCard();
        double amount = bankCard1.getAmount();
        System.out.printf("Card %s contains %s money",
                richCompany.getBankCardNull().getAmount(),
                richCompany.getBankCard().getName());


    }

    private static void transaction(BankCard from,
                                    BankCard to,
                                    int amount) {
        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);
    }


    private static void catExample() {
        Cat murzik = new Cat("murzik", 5);
        Plate plateFullOfFood = new Plate(100);
        murzik.eat(plateFullOfFood);
    }

    private static void firstExample() {
        String name = "Anton";
        String alterName = "Anton";
        String fullname = name + " Batiaev";

        String name2 = new String("Anton");
        String name3 = new String(new char[]{'A', 'n', 't', 'o', 'n'});

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        String s = stringBuilder.toString();

        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(i);
            stringBuffer.append(new Object());
        }
        String s2 = stringBuffer.toString();
        stringBuffer.capacity();
        stringBuffer.trimToSize();
    }
}
