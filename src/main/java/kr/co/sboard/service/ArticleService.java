package kr.co.sboard.service;

import kr.co.sboard.dao.ArticleMapper;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.Article;
import kr.co.sboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private ArticleMapper articleMapper;

    public void register(ArticleDTO articleDTO) {

        // 엔티티 변환
        Article article = modelMapper.map(articleDTO, Article.class);

        // JPA
        // articleRepository.save(article);

        // Mybatis 저장
        articleMapper.insertArticle(articleDTO);

    }


}
