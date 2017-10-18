package cn.myth.MoodBlog.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.myth.MoodBlog.StringUtils;
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
    	
    	
    	Roles role1 = new Roles(1,"ROLE_ADMIN","管理员权限");
    	Roles role2= new Roles(2,"ROLE_USER","普通用户权限");
    	rolesDao.save(role1);
    	rolesDao.save(role2);
    	
    	Resource res1= new Resource(1,"index", "URL", "/index", "主页",role2);
    	Resource res2= new Resource(2,"admin", "URL", "/admin", "后台界面入口",role1);
    	Resource res3= new Resource(3,"admin", "URL", "/index", "后台界面入口",role1);
    	rescDao.save(res1);
    	rescDao.save(res2);	
    	rescDao.save(res3);	

    	User admin = new User(1,"admin","111",true,role1);
    	userDao.save(admin);
    	
    	
        StringUtils.printString(InitData.class, "初始化数据......");
    }
}
