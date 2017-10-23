package cn.myth.MoodBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cn.myth.MoodBlog.data.Articles;

@Repository
public interface ArticleDao extends JpaRepository<Articles, Integer>, JpaSpecificationExecutor<Articles> {

}
