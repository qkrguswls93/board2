package jmp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class BoardController {

	@Autowired
	BoardService service;
	
	//등록 페이지로 이동
	@GetMapping("/board/register")
	public void insert() {
		log.info("=====insert() ");
	}
	
	@PostMapping("/board/register")
	public String insertExe(BoardVo vo, RedirectAttributes rttr) {
							//파라미터수집
		log.info(vo);
		int res = service.insertBoard(vo);
		log.info("========"+vo);
		
		rttr.addFlashAttribute("resMsg", vo.getBno()+" 번 게시물 등록 되었습니다.");
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list") //redirect 값
	public void getList(Model model) { //model은 컨트롤러의 매개변수
		
		model.addAttribute("list",service.getList());
		
		log.info("getList()=======");
	}

	
	
	//연습
	@GetMapping("/board/titleboard")
	public void gettitle() {
		
		log.info("=====gettitle()");
	}
	
	@GetMapping("/board/titleregister")
	public void titleregister() {
		log.info("=====titleregister");
	}
	
	@PostMapping("/board/titleregister")
	public String titleregisterf(BoardVo vo, RedirectAttributes rttr) {
		
		int res = service.insertBoard(vo);
		rttr.addFlashAttribute("resMsg", vo.getBno()+" 번 게시물 등록 되었습니다.");
		return "redirect:/board/list";
		
	}
	
}
