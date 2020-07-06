package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	private PhoneDao phoneDao;	// = new PhoneDao(); --> 자동으로 이 기능을 실행해준다.
	
	
	
	
//	list --------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST}) 	// --> 주소 체계
	public String list(Model model) {
		System.out.println("/pb3/phone/list");
		
		List<PersonVo> pList = phoneDao.getPersonList();
		
		model.addAttribute("pList", pList);
		
		
		return "list";		// return은 jsp를 알려주는 곳 
	}
		
////	writeForm ---------------------------------------------------------------------------------------
//	
//	@RequestMapping(value = "/writeForm", method = {RequestMethod.GET, RequestMethod.POST})
//	public String writeForm() {
//		System.out.println("/pb3/phone/writeForm");
//		
//		return "writeForm";
//	}
//	
////	write -------------------------------------------------------------------------------------------
//	
//	//1번째방법
//	@RequestMapping(value = "/write", method = RequestMethod.GET)
//	public String write(@ModelAttribute PersonVo personVo) {
//		System.out.println("/pb3/phone/write");
//		
//		System.out.println(personVo.toString());
//		
//		phoneDao.personInsert(personVo);
//		
//		return "redirect:/phone/list";		//	-->	이렇게 하면 위의 list 명령어로 보내집니다. 주소체계로 입력해야 합니다.
//	}
//	
////	//2번째 방법 (선호하지 않음)
////	@RequestMapping(value = "/write", method = RequestMethod.GET)
////	public String write(@RequestParam("name") String name,
////						@RequestParam("hp") String hp,
////						@RequestParam("company") String company) {
////		System.out.println("/pb3/phone/write");
////
////		System.out.println(name + "," + hp + "," + company);
////		
////		return "/WEB-INF/views/writeForm.jsp";
////	}
//		
//
//	
////	updateForm --------------------------------------------------------------------------------------
//	
//	@RequestMapping(value = "/updateForm", method = {RequestMethod.GET, RequestMethod.POST})
//	public String updateForm(Model model, @RequestParam("personId") int personId) {
//		System.out.println("/pb3/phone/updateForm");
//		
//		PersonVo personVo = phoneDao.getPerson(personId);
//		model.addAttribute("personVo", personVo);
//
//		return "updateForm";
//	}
//
////	update ------------------------------------------------------------------------------------------
//	
//	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
//	public String update(@ModelAttribute PersonVo personVo) {
//		System.out.println("/pb3/phone/update");
//
//		
//		phoneDao.personUpdate(personVo);
//		System.out.println(personVo.toString());
//		
//		
//		
//		return "redirect:/phone/list";
//	}
//	
////	delete ------------------------------------------------------------------------------------------
//	
//	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
//	public String delete(@RequestParam("personId") int personId) {
//		System.out.println("/pb3/phone/delete");
//		
//		phoneDao.personDelete(personId);
//		System.out.println(personId);
//		
//		return "redirect:/phone/list";
//		
//	}

}
