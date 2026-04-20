package com.asdf.buddyboard;

import org.springframework.boot.SpringApplication;

public class TestBuddyBoardApplication {

    public static void main(String[] args) {
        SpringApplication.from(BuddyBoardApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
