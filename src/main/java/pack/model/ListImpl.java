package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ListImpl extends SqlSessionDaoSupport implements ListInter{
	@Autowired
	public ListImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public List<JikwonDto> selectDataAll() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectDataAll");
	}
	
	@Override
	public List<JikwonDto> selectDataBuser(String buser_num){
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectDataBuser", buser_num);
	}
	
	@Override
	public BuserDto selectBuser(String buser_num){
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectBuser", buser_num);
	}
}

