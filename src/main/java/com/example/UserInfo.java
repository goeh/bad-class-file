package com.example;

import java.util.List;

public record UserInfo(String username, List<String> authorities) {
}
