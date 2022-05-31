package com.example.board.service;

import java.util.List;

import com.example.board.dto.Board;
import com.example.board.dto.PageInfo;

public interface BoardService {
	public void writerBoard(Board board) throws Exception;
	List<Board> getBoardList(int page, PageInfo pageInfo) throws Exception;
	Board getBoard(int boardNum) throws Exception;
	void modifyBoard(Board board) throws Exception;
	void writeReply(Board board) throws Exception;
	void removeBoard(int boardNum, String boardPass) throws Exception;
}
