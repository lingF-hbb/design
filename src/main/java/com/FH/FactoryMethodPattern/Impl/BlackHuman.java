package com.FH.FactoryMethodPattern.Impl;

import com.FH.FactoryMethodPattern.Human;

public class BlackHuman implements Human {
    @Override
    public void talk() {
        System.out.println("黑色人种会说话");
    }

    @Override
    public void laugh() {
        System.out.println("黑色人种会笑，漏牙那种");
    }

    @Override
    public void cry() {
        System.out.println("黑色人种会哭");
    }
}
