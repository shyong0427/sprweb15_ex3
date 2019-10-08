package pack.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BuserDto;
import pack.model.JikwonDto;
import pack.model.ListInter;

@Controller
public class JikwonController {
		
	@Autowired
	@Qualifier("listImpl")
	private ListInter listInter;
	
	@RequestMapping("jikwon")
	public ModelAndView selectDataAll() {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)listInter.selectDataAll();
		return new ModelAndView("list","data",list);
	}
	
	@RequestMapping("searchBuser")
	public ModelAndView selectDataBuser(HttpServletRequest request) {
		String buser_num = request.getParameter("buser_num");
		if(buser_num.equals("all")) {
			return selectDataAll();
		}else {
			ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)listInter.selectDataBuser(buser_num);
			return new ModelAndView("list","data",list);
		}
	}
	
	@RequestMapping("buser")
	public ModelAndView selectBuser(HttpServletRequest request) {
		String buser_num = request.getParameter("num");
		BuserDto dto = listInter.selectBuser(buser_num);
		return new ModelAndView("list2","data",dto);
	}	
}
		
