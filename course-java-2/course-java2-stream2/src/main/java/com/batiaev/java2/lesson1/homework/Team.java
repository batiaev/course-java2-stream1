package com.batiaev.java2.lesson1.homework;

public class Team {
    //    private List<Member> members = new ArrayList<>();
    private Member[] members;
    private String name;

    public Team(String teamName, Member... animals) {
        members = animals;
    }

    public void showResults() {
        for (Member member : members) {
            String result = member.getResult() ? "passed" : "failed";
            System.out.println("Member " + name + " is " + result);
        }
    }

    public Member[] getMembers() {
        return members;
    }
}
