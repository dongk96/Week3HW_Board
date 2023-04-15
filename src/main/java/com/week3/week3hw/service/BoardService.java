package com.week3.week3hw.service;

import com.week3.week3hw.DTO.BoardPasswordDto;
import com.week3.week3hw.DTO.BoardRequestDto;
import com.week3.week3hw.DTO.BoardResponseDto;
import com.week3.week3hw.entity.Board;
import com.week3.week3hw.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public String createBoard(BoardRequestDto boardRequestDto){
        Board board = new Board(boardRequestDto);

        boardRepository.save(board);

        return "게시글 등록을 완료하였습니다.";
    }

    public List<BoardResponseDto> getBoardList() {
        List<BoardResponseDto> responseDtoList = new ArrayList<>();
        //작성 날짜 기준 내림차순 정렬
//        List<Board> boards = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
//
//        for(Board board : boards){
//            BoardResponseDto boardResponseDto = new BoardResponseDto(board);
//            responseDtoList.add(boardResponseDto);
//        }
//
//        return responseDtoList;
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")).stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    public BoardResponseDto getBoard(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 게시글이 없습니다.")
        );

        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto){


        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 게시글이 없습니다.")
        );

        if (!board.getPassword().equals(boardRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        board.update(boardRequestDto);

        return new BoardResponseDto(board);
    }

    public String deleteBoard(Long id, BoardPasswordDto boardPasswordDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 게시글이 없습니다.")
        );

        if (!board.check(boardPasswordDto)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        boardRepository.delete(board);

        return "선택한 게시글을 삭제하였습니다.";
    }
}
