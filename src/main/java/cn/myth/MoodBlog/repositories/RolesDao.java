package cn.myth.MoodBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cn.myth.MoodBlog.data.Roles;

@Repository
public interface RolesDao extends JpaRepository<Roles,Integer> ,JpaSpecificationExecutor<Roles>{

	@Override
	default <S extends Roles> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
