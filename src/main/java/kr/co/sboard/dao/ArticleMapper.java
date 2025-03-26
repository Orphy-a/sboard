package kr.co.sboard.dao;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper // mybatis
public interface ArticleMapper {

    public void insertArticle(ArticleDTO articleDTO);

}
