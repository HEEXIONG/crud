package com.spring.crud.impl;

import javax.smartcardio.ATR;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.crud.ArticleVO;

@Repository
public class ArticleDAO {
	
	//MyBatis 탬플릿 활용
	private SqlSessionTemplate mybatis;

	
	@Autowired
	public ArticleDAO(SqlSessionTemplate mybatis) {
		super();
		this.mybatis = mybatis;
	}
	
	
	public void insert(ArticleVO vo) {
		mybatis.insert("ArticleDAO.insert",vo);
	}
	public ArticleVO selectById(ArticleVO vo) {
		return(ArticleVO) mybatis.selectOne("ArticleDAO.selectById", vo);
	}
	public ArticleVO update(ArticleVO vo) {
		return(ArticleVO) mybatis.selectOne("ArticleDAO.update", vo);
	}
	public ArticleVO delete(ArticleVO vo) {
		return(ArticleVO) mybatis.selectOne("ArticleDAO.delete", vo);
	}//5-1
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
