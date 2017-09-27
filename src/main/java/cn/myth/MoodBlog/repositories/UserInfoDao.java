package cn.myth.MoodBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.myth.MoodBlog.entity.UserInfo;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo,Integer> ,JpaSpecificationExecutor<UserInfo>{
	
	@Query("select a from UserInfo a where a.id=:id")
	public UserInfo findInfo(@Param("id")int id);
}
