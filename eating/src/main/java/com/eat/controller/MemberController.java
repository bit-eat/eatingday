package com.eat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.dao.EateryBookmarkDAO;
import com.eat.dao.RecipeBookmarkDAO;
import com.eat.service.EateryService;
import com.eat.service.MemberService;
import com.eat.service.RecipeService;
import com.eat.vo.MemberVO;
import com.eat.vo.RecipeBookmarkVO;
import com.eat.vo.RecipeVO;

@Controller
public class MemberController {

	@Autowired
	private RecipeService recipeservice;

	@Autowired
	private MemberService memberservice;

	@Autowired
	private EateryService eateryservice;

	@Autowired
	private RecipeBookmarkDAO recipeBookmarkdao;

	@Autowired
	private EateryBookmarkDAO eateryBookmarkdao;

	@GetMapping("/Login") // 로그인
	public void Login() {
	}

	@GetMapping("/mypage")    // 마이페이지
	public void mypage() {
	}

	@GetMapping("/register")
	public String register() {       // 회원가입창띄우기
		return "register";
	}

	@PostMapping("insertMember")
	public String insertMember(MemberVO membervo) {        // 회원가입
		System.out.println(membervo);
		memberservice.insertMember(membervo);
		return "/Login";
	}

	@GetMapping("/findid")           // 아이디찾기
	public String findid() {
		return "/findid";
	}

	@PostMapping("findId")             // 아이디찾기
	public void findId(Model model, @RequestParam("userName") String userName,
					   @RequestParam("phoneNumber") String phoneNumber) {
		model.addAttribute("findId", memberservice.findId(userName, phoneNumber));
		System.out.println(model);
	}

	@GetMapping("/findpw")
	public String findpw() {       // 비밀번호찾기
		return "/findpw";
	}

	@PostMapping("/findPw")                   // 비밀번호찾기
	public void findPw(Model model, @RequestParam("userName") String userName, @RequestParam("userId") String userId,
					   @RequestParam("phoneNumber") String phoneNumber) {
		System.out.println(phoneNumber);
		model.addAttribute("findPw", memberservice.findPw(userName, phoneNumber, userId));
	}

	@PostMapping("/Login") // 로그인
	public String Login(HttpSession session,String userId,String userPw,Long id) {
		int check = memberservice.logincheck(userId, userPw);
		if(check==1) {
			session.setAttribute("loginCheck", true);
			session.setAttribute("userId", userId);
			session.setAttribute("member", memberservice.selectMemberId(userId));
			return "redirect:/";
		} else {
			return "/Login";
		}
	}

	@GetMapping("/LogOut") // 로그아웃
	public String LogOut(HttpSession session) {
		session.setAttribute("loginCheck", null);
		session.setAttribute("userId", null);
		session.removeAttribute("member");
		return "/Login";
	}

	@PostMapping("admincheck")
	public String admincheck(Model model, String userId, String userPw) {                  // 관리자 로그인
		model.addAttribute("admincheck", memberservice.admincheck(userId, userPw));
		int check = memberservice.admincheck(userId, userPw);
		if (check == 1) {
			return "redirect:/memberList";
		} else {
			return "/adminlogin";
		}
	}

	@GetMapping("update")
	public void update(HttpSession session,Model model) {     // 수정(개인정보수정)
		String userId = (String) session.getAttribute("userId");
		model.addAttribute("selectOne",memberservice.selectOne(userId));
	}

	@PostMapping("update")
	public void updateMember(MemberVO membervo) { // 수정(개인정보수정)
		System.out.println(membervo);
		memberservice.updateMember(membervo);
	}


	@GetMapping("/delete")
	public String delete() {   // 회원탈퇴 ,페이지 불러오기
		return "delete";
	}

	@PostMapping("/delete")
	public String deleteMember(MemberVO membervo) { // 삭제(회원탈퇴) , 정보전달 받은거 처리하기
		memberservice.deleteMember(membervo);
		return "/Login";
	}

	@GetMapping("/adminlogin")
	public String adminLogin(MemberVO membervo) {   // 관리자 로그인
		System.out.println(membervo);
		return "/adminlogin";
	}

	@GetMapping("/memberList")
	public void selectAll(Model model) {   // 회원 목록 불러오기
		model.addAttribute("selectAll", memberservice.selectAll());
	}

	@PostMapping("deletecheck") // 관리자 회원 관리 삭제
	public String deletecheck(@RequestParam("id") List<Long> id) {
		memberservice.deletecheck(id);
		return "redirect:/memberList";
	}

	@GetMapping("favorite")   //즐겨찾기 페이지
	public String favorite(Model model,HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute("member");
		model.addAttribute("selectEateryBookmark",eateryBookmarkdao.selectEateryBookmark(member.getId()));

		model.addAttribute("selectRecipeBookmark",recipeBookmarkdao.selectRecipeBookmark(member.getId()));
		return "/favorite";
	}

	@PostMapping("updateMemberList") //멤버리스트 수정
	public String updatememberList(MemberVO membervo) {
		System.out.println(membervo);
		memberservice.updateMemberList(membervo);
		return "redirect:/memberList";
	}

	@GetMapping("adminEateryList")   //관리자 음식점 게시판
	public String adminEateryList(Model model){
		model.addAttribute("selectAll", eateryservice.selectAll());
		return "/adminEateryList";
	}

	@PostMapping("adminEaterydelete")   //관리자 음식점 게사판 삭제
	public String adminEaterydelete(@RequestParam("id") List<Long> id) {
		memberservice.adminEateryDelete(id);
		return "redirect:/adminEateryList";
	}

	@GetMapping("adminRecipeList")   //관리자 레시피 게시판
	public String adminRecipeList(Model model){
		model.addAttribute("selectAll", recipeservice.selectAll());
		return "/adminRecipeList";
	}

	@PostMapping("adminRecipedelete")   //관리자 레시피 게시판 삭제
	public String adminRecipedelete(@RequestParam("id") List<Long> id) {
		memberservice.adminRecipedelete(id);
		return "redirect:/adminRecipeList";
	}
}