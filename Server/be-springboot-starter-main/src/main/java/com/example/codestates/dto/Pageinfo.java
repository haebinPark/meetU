package com.example.codestates.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pageinfo {
    private int page;
    private int size;
    private long totalElements;
    private int toalPages;
}
