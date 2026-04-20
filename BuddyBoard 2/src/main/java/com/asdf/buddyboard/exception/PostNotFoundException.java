package com.asdf.buddyboard.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String message){
        super(message);
    }

    public PostNotFoundException(){
        super("게시글을 찾을 수 없습니다.");
    }
}
