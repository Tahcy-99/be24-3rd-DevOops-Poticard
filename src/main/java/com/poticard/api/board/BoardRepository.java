package com.poticard.api.board;

import com.poticard.api.board.model.BoardDto;

public interface BoardRepository {
    public BoardDto read(String boardIdx);
    public BoardDto create(BoardDto dto);
}
