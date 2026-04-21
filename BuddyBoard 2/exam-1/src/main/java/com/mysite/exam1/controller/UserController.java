package com.mysite.exam1.controller;

import com.mysite.exam1.entity.User;
import com.mysite.exam1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User API", description = "사용자 가입 및 차단 관련 API")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "회원 가입", description = "새로운 사용자를 등록합니다. (추천인 ID 포함 가능)")
    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @Operation(summary = "사용자 차단", description = "내 ID(myId)로 특정 사용자(targetId)를 차단합니다.")
    @PostMapping("/{myId}/blocks/{targetId}")
    public String blockUser(@PathVariable Long myId, @PathVariable Long targetId) {
        return userService.blockUser(myId, targetId);
    }
}