package com.asdf.buddyboard.exception;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(String message){
        super(message);
    }
    public MemberNotFoundException(){
        super("멤버를 찾을 수 없습니다.");
    }
}
