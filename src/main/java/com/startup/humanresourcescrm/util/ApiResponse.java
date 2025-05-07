package com.startup.humanresourcescrm.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse <T>{
    public String title;
    public T data;

    public ApiResponse (String title) {
        this.title = title;
    }
}
