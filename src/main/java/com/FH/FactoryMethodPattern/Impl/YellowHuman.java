package com.FH.FactoryMethodPattern.Impl;

import com.FH.FactoryMethodPattern.Human;

public class YellowHuman implements Human {
    @Override
    public void talk() {
        System.out.println("黄色人种说话");
    }

    @Override
    public void laugh() {
        System.out.println("黄色人种大笑");
    }

    @Override
    public void cry() {
        System.out.println("黄色人种大哭");
    }
}
