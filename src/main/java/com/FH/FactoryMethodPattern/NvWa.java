package com.FH.FactoryMethodPattern;

import com.FH.FactoryMethodPattern.Impl.WhiteHuman;

public class NvWa {
    public static void main(String[] args) {
        System.out.println("造出来的第一批是白人");
        Human human = HumanFactory.createHuman(WhiteHuman.class);
        human.cry();

        Human human1 = HumanFactory.createHuman();
        human1.laugh();
    }
}
