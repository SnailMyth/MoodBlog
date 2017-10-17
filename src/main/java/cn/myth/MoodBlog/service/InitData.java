package cn.myth.MoodBlog.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.myth.MoodBlog.data.Resource;
import cn.myth.MoodBlog.data.Roles;
import cn.myth.MoodBlog.data.User;
import cn.myth.MoodBlog.repositories.RescDao;
import cn.myth.MoodBlog.repositories.RolesDao;
import cn.myth.MoodBlog.repositories.UserDao;

@Component
public class InitData {
	@Autowired
	UserDao userDao;
	@Autowired
	RolesDao rolesDao;
	@Autowired
	RescDao rescDao;
	

    @PostConstruct
    public void init() {
    	Resource res1 = new Resource(1,"admin", "URL", "/index", "主页");
    	Resource res2 = new Resource(2,"admin", "URL", "/admin", "后台界面入口");
    	rescDao.save(res1);
    	rescDao.save(res2);
    	
    	List<Resource> list1 = new ArrayList<>();
    	List<Resource> list2 = new ArrayList<>();
    	list1.add(res1);
    	list1.add(res2);
    	
    	list2.add(res1);
    	
    	Roles role1 = new Roles(1,"ROLE_ADMIN","管理员权限",list1);
    	Roles role2= new Roles(2,"ROLE_USER","普通用户权限",list2);
    	rolesDao.save(role1);
    	rolesDao.save(role2);
    	
    	User admin = new User(1,"admin","111",true,role1);
    	userDao.save(admin);
    	
    	
        System.out.println("初始化数据......");
    }
}
