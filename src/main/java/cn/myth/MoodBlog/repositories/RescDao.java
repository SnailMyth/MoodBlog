package cn.myth.MoodBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cn.myth.MoodBlog.data.Resource;

@Repository
public interface RescDao extends JpaRepository<Resource,Integer> ,JpaSpecificationExecutor<Resource>{

}
