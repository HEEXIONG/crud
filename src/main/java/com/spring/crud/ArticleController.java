package com.spring.crud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

	// 의존주입
	@Autowired
	private ArticleService articleService;

	// @ModelAttribute("article")은 아래의 모든 매서드들에게
	// request.setAttribute("article",articleService.selectById(vo))을
	// 해주는 것과 같은 역할을 합니다.
	@ModelAttribute("article")
	public ArticleVO getArticle() {
		ArticleVO vo = new ArticleVO();
		return articleService.selectById(vo);
	}

	// 1. 게시글 등록 처리기능의 insert() 매서드 정의
	@RequestMapping("/article/write.do")
	public String insert(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		return Process(request, response, vo, "insert");
	}

	// 2.최근 게시글 조회기능의 selectById())매서드 정의
	@RequestMapping("/article/read.do")
	public String selectById(ArticleVO vo) {
		return "/WEB-INF/views/readArticle.jsp";
	}

	// 3.최근 게시글 수정 기능의update() 매서드 정의
	@RequestMapping("/article/modify.do")
	public String update(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		return Process(request, response, vo, "update");
	}

	// 3.최근 게시글 수정 기능의update() 매서드 정의
	@RequestMapping("/article/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response, ArticleVO vo) {
		return Process(request, response, vo, "delete");
	}

	// GET,POST 그밖의 요청들을 분기 처리를 해주는 process()매서드 정의
	private String Process(HttpServletRequest request, HttpServletResponse response, ArticleVO vo, String query) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return viewResolverForm(query);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			executeQuery(query, vo);
			return viewresolverSuccess(query);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}

	}

	// 폼 화면 경로를 만들어주는 veiewResolverForm()매소드 정의
	private String viewResolverForm(String viewName) {
		return "/WEB-INF/views/" + viewName + "Form.jsp";
	}

	// 성공 화면 경로를 만들어주는 viewResolverSuccess()매서드 정의
	private String viewresolverSuccess(String viewName) {
		return "/WEB-INF/views/" + viewName + "Success.jsp";
	}

	// 입력한 쿼리문에 딸 다른 메서드를 실행처리하는 executeQuery() 매서드 정의
	private void executeQuery(String query, ArticleVO vo) {
		if (query == "insert") {
			articleService.insert(vo);
		} else if (query == "update") {
			articleService.update(vo);
		} else if (query == "delete") {
			articleService.delete(vo);
		}

	}// 6

}
