package com.FH.FactoryMethodPattern.Impl;

import com.FH.FactoryMethodPattern.Human;

public class WhiteHuman implements Human
{
    @Override
    public void talk() {
        System.out.println("白人会说话");
    }

    @Override
    public void laugh() {
        System.out.println("白人也会笑");
    }

    @Override
    public void cry() {
        System.out.println("白人哭的很假");
    }
}
