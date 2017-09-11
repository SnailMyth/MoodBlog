package cn.myth.MoodBlog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.myth.MoodBlog.entity.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public User getUserById(String id) {
		return (User) this.getSession().createQuery("from User where u_id= ?").setParameter(0, id).uniqueResult();
	}

	/**
	 * 添加
	 * @param person
	 */
	public void addUser(User person) {
		this.getSession().save(person);
	}

	/**
	 * 更新
	 * @param person
	 */
	public void updateUser(User person) {
		this.getSession().update(person);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteUserById(String id) {
		this.getSession().createQuery("delete User where id=?").setParameter(0, id).executeUpdate();
	}

}
