package com.week3.week3hw.entity;

import com.week3.week3hw.DTO.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Board extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String contents;

    // Board 클래스의 생성자
    // -> CourseRequestDto 객체를 인자로 받아 해당 객체의 필드 값을 가져와 title, instructor, cost 필드에 할당
    public Board(BoardRequestDto boardRequestDto){
        this.password = boardRequestDto.getPassword();
        this.title = boardRequestDto.getTitle();
        this.author = boardRequestDto.getAuthor();
        this.contents = boardRequestDto.getContents();
    }

    public void update(BoardRequestDto boardRequestDto){
        //this.id = boardRequestDto.getId();
        this.password = boardRequestDto.getPassword();
        this.title = boardRequestDto.getTitle();
        this.author = boardRequestDto.getAuthor();
        this.contents = boardRequestDto.getContents();
    }
}
