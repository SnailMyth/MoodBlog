package cn.myth.MoodBlog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.myth.MoodBlog.data.Articles;
import cn.myth.MoodBlog.data.User;

@Repository
public interface ArticleDao extends JpaRepository<Articles, Integer>, JpaSpecificationExecutor<Articles> {

	@Query("select a from Articles a where author=:id")
	public List<Articles> authorList(@Param("id")User id);
}
