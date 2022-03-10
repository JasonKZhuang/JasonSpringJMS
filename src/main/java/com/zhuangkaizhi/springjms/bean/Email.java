package com.zhuangkaizhi.springjms.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jason Zhuang
 * @date : 11/3/2022
 * @description :
 */
@Data
@NoArgsConstructor
public class Email {

    private String to;
    private String body;

    public Email(String to, String body) {
        this.to = to;
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("Email{to=%s, body=%s}", getTo(), getBody());
    }

}