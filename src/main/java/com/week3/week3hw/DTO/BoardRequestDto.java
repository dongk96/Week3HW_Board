package com.week3.week3hw.DTO;

import lombok.Getter;

@Getter
//일반적으로 DTO 클래스는 단순히 데이터를 저장하기 위한 용도로 사용되기 때문에, 별도의 생성자가 필요하지 않음
public class BoardRequestDto {
    private Long id;
    private String password;
    private String title;
    private String author;
    private String contents;
}
