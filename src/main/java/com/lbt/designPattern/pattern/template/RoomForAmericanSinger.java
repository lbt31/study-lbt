package com.lbt.designPattern.pattern.template;

public class RoomForAmericanSinger extends KTVRoom {

    @Override
    protected void orderSong() {
        System.out.println("Chinese song in English version please...");
    }
}

