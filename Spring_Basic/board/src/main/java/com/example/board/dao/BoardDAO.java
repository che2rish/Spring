package com.example.board.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.board.dto.Board;

@Repository
@Mapper
public interface BoardDAO {
	void insertBoard(Board board) throws SQLException;
	Integer selectMaxBoardNum() throws SQLException;
	List<Board> selectAllBoard(int startrow) throws SQLException;
	int selectBoardCount() throws SQLException;
	Board selectBoard(int boardNum) throws SQLException;
	void updateReadCount(int boardNum) throws SQLException;
	String selectPassword(int boardNum) throws SQLException;
	void updateBoard(Board board) throws SQLException;
	void updateBoardReSeq(Board board) throws SQLException;
	void deleteBoard(int boardNum)throws SQLException;
}
