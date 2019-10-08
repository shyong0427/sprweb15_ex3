package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ListInter {
	List<JikwonDto> selectDataAll();
	List<JikwonDto> selectDataBuser(String buser_num);
	BuserDto selectBuser(String buser_num);
}
