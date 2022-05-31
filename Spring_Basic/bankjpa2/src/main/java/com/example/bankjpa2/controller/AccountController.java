package com.example.bankjpa2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bankjpa2.dto.Account;
import com.example.bankjpa2.model.AccountEntity;
import com.example.bankjpa2.service.AccountService;


@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String main() {
		return "bankmain";
	}
	
	@GetMapping("/makeAccount")
	public String makeAccount() {
		return "makeAccount";
	}
	
	// 방법 1
	@PostMapping("/makeAccount")
	public ModelAndView makeAccount(@ModelAttribute Account acc) {
		ModelAndView mav = new ModelAndView(); // 데이터와 뷰를 동시에..??
		try {
			accountService.makeAccount(acc);
			Account racc = accountService.accountInfo(acc.getId());
			mav.setViewName("accountInfo_res");
			mav.addObject("acc",racc);
		}catch(Exception e) {
			mav.setViewName("err");
			mav.addObject("err","계좌개설 오류");
		}
		return mav;
	}
	
	@GetMapping("accountInfo")
	public String accountInfo() {
		return "accountInfo";
	}
	
	// 방법2
	@PostMapping("accountInfo")
	public String accountInfo(@RequestParam("id") String id, Model model) {
		try {
			Account acc = accountService.accountInfo(id);
			model.addAttribute("acc",acc);
			return "accountInfo_res";
		}catch(Exception e) {
			model.addAttribute("err", e.getMessage());
			return "err";
		}
	}
	
	@GetMapping("deposit")
	public String deposit() {
		return "deposit";
	}
	

	@PostMapping("deposit")
	public String deposit(@RequestParam("id") String id, @RequestParam("money") int money ,Model model) {
		try {
			accountService.deposit(id, money);
			Account acc = accountService.accountInfo(id);
			model.addAttribute("acc",acc);
			return "accountInfo_res";
		}catch(Exception e) {
			model.addAttribute("err", e.getMessage());
			return "err";
		}
	}
	
	@GetMapping("withdraw")
	public String withdraw() {
		return "withdraw";
	}
	

	@PostMapping("withdraw")
	public String withdraw(@RequestParam("id") String id, @RequestParam("money") int money ,Model model) {
		try {
			accountService.withdraw(id, money);
			Account acc = accountService.accountInfo(id);
			model.addAttribute("acc",acc);
			return "accountInfo_res";
		}catch(Exception e) {
			model.addAttribute("err", e.getMessage());
			return "err";
		}
	}
	
	@GetMapping("allAccountInfo")
	public String allAccountInfo(Model model) {
		try {
			List<AccountEntity> acc = accountService.accountList();
			model.addAttribute("accs", acc);
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return "err";
		}
		return "allAccountInfo";
	}
	
}
