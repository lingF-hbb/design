package com.FH.SingletonPattern;

@SuppressWarnings("all")
public class Minister {
    public static void main(String[] args) {
        Emperor emperor = Emperor.getInstance();
        Emperor.say();
    }
}
