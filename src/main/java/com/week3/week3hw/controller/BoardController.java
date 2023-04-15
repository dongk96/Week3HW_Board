package com.week3.week3hw.controller;

import com.week3.week3hw.DTO.BoardPasswordDto;
import com.week3.week3hw.DTO.BoardRequestDto;
import com.week3.week3hw.DTO.BoardResponseDto;
import com.week3.week3hw.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public String createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/list")
    public List<BoardResponseDto> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PutMapping("/update/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        //@PathVariable Long id: id는 URL 경로(Path)에서 추출되는 경로 변수(Path Variable)로, Long 타입의 값을 받아옴
        //requestDto는 HTTP 요청의 본문(Request Body)에 담긴 데이터를 바인딩하여 객체로 받아옴
        return boardService.updateBoard(id, boardRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestBody BoardPasswordDto boardPasswordDto){
        return boardService.deleteBoard(id, boardPasswordDto);
    }
}
