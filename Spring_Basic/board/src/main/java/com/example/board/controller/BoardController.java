package com.example.board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.Board;
import com.example.board.dto.PageInfo;
import com.example.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "/board/writeform";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView boardwriter(@ModelAttribute Board board) {
		ModelAndView mav = new ModelAndView();
		try {
			if(!board.getFile().isEmpty()) {
				String path = servletContext.getRealPath("/boardupload/");
				File destFile = new File(path + board.getFile().getOriginalFilename());
				board.setBoard_file(board.getFile().getOriginalFilename());
				board.getFile().transferTo(destFile);
			}else {
				board.setBoard_file("");
			}
			boardService.writerBoard(board);
			mav.setViewName("redirect:/board/boardList");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","새글 등록 실패");
			mav.setViewName("/board/err");
		}
		return mav;
	}
	
	@GetMapping("/boardList")
	public ModelAndView boardList(@RequestParam(value = "page",required = false, defaultValue = "1")int page) {
		ModelAndView mav = new ModelAndView();
		PageInfo pageInfo = new PageInfo();
		try {
			List<Board> articleList = boardService.getBoardList(page, pageInfo);
			mav.addObject("articleList",articleList);
			mav.addObject("pageInfo", pageInfo);
			mav.setViewName("/board/listform");
			
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","글 목록 조회 실패");
			mav.setViewName("/board/err");
		}
		return mav;
	}
	
	@GetMapping("/boarddetail")
	public ModelAndView boarddetail(@RequestParam(value = "board_num") int boardNum,
			@RequestParam(value = "page",required = false, defaultValue = "1")int page) {
		ModelAndView mav = new ModelAndView();
		try {
			Board board = boardService.getBoard(boardNum);
			mav.addObject("article",board);
			mav.addObject("page",page);
			mav.setViewName("/board/viewform");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","글 상세조회 실패");
			mav.setViewName("/board/err");
		}
		return mav;
	}
	
	@GetMapping("/modifyform")
	public ModelAndView modifyform(@RequestParam(value = "board_num") int boardNum) {
		ModelAndView mav = new ModelAndView();
		try {
			Board board = boardService.getBoard(boardNum);
			mav.addObject("article",board);
			mav.setViewName("/board/modifyform");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","글 수정 실패");
			mav.setViewName("/board/err");
		}
		return mav;
	}
	
	@PostMapping("/boardmodify")
	public ModelAndView boardmodify(@ModelAttribute Board board) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.modifyBoard(board);
			mav.addObject("board_num",board.getBoard_num());
			mav.setViewName("redirect:/board/boarddetail");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err",e.getMessage());
			mav.setViewName("/board/err");
		}
		return mav;
	}
	
	@GetMapping("/replyform")
	public ModelAndView replyform(@RequestParam(value="board_num") int boardNum,
			@RequestParam(value = "page",required = false, defaultValue = "1")int page) {
		ModelAndView mav = new ModelAndView();
		try {
			mav.addObject("page",page);
			mav.addObject("boardNum", boardNum);
			mav.setViewName("/board/replyform");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","답변 화면 조회 오류");
			mav.setViewName("/board/err");
		}
		return mav;
	}

	@PostMapping("/boardreply")
	public ModelAndView boardreply(@ModelAttribute Board board,
			@RequestParam(value = "page",required = false, defaultValue = "1")int page) {
		ModelAndView mav = new ModelAndView();
		try {
			board.setBoard_file("");
			boardService.writeReply(board);
			mav.addObject("page",page);
			mav.setViewName("redirect:/board/boardList");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","답변 오류");
			mav.setViewName("/board/err");
		}
		return mav;
	}
	
	@GetMapping("/deleteform")
	public ModelAndView deleteform(@RequestParam(value="board_num") int boardNum,
			@RequestParam(value = "page",required = false, defaultValue = "1")int page) {
		ModelAndView mav = new ModelAndView();
		try {
			mav.addObject("board_num",boardNum);
			mav.addObject("page",page);
			mav.setViewName("/board/deleteform");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","삭제 화면 조회 오류");
			mav.setViewName("/board/err");
		}
		return mav;
	}
	
	@PostMapping("/boarddelete")
	public ModelAndView boarddelete(@RequestParam(value="board_num") int boardNum,
			@RequestParam(value = "board_pass") String boardPass,
			@RequestParam(value = "page",required = false, defaultValue = "1")int page) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.removeBoard(boardNum, boardPass);
			mav.addObject("page", page);
			mav.setViewName("redirect:/board/boardList");
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err","삭제 오류");
			mav.setViewName("/board/err");
		}
		return mav;
	}
}
