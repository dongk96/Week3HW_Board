package com.week3.week3hw.DTO;

import com.week3.week3hw.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String password;
    private String title;
    private String author;
    private String contents;

    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.password = board.getPassword();
        this.title = board.getTitle();
        this.author = board.getAuthor();
        this.contents = board.getContents();
    }
}
