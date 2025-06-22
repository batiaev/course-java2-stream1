package com.batiaev.java3.lesson7;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AccountDatabase implements Database<Account> {

    public static void main(String[] args) {
        AccountDatabase database = new AccountDatabase();
        database.createTable(Account.class);
    }

    public void createTable(Class<Account> accountClass) {
        Table annotationTable = accountClass.getAnnotation(Table.class);
        if (annotationTable != null) {
            String tableName = annotationTable.value();
            if (!tableName.isEmpty()) {
                List<String> fields = new ArrayList<>();
                Field[] declaredFields = accountClass.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    com.batiaev.java3.lesson7.Field annotation = declaredField.getAnnotation(
                            com.batiaev.java3.lesson7.Field.class);
                    String value = annotation != null ? annotation.value() : declaredField.getName();

                    Class<?> type = declaredField.getType();
                    String sqlTypeName;
                    if (type.equals(String.class)) {
                        sqlTypeName = " varchar(100)";
                    } else if (type.equals(Integer.class)) {
                        sqlTypeName = " int";
                    } else {
                        sqlTypeName = " varchar(255)";
                    }


                    String fieldData = value + sqlTypeName;
                    PrimaryKey pk = declaredField.getAnnotation(PrimaryKey.class);
                    if (pk != null) {
                        fieldData += " PRIMARY KEY";
                    }
                    fields.add(fieldData);
                }


                StringBuilder stringBuilder = new StringBuilder("CREATE TABLE " + tableName + " (");
                fields.forEach(s -> stringBuilder.append(s).append(", "));
                stringBuilder.append(" ) ");
                String query = stringBuilder.toString();
                System.out.println(query);
            }
        }
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>();//FIXME
    }
}
