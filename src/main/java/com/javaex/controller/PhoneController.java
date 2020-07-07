package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/phone")
public class PhoneController {

	@Autowired
	private PhoneDao phoneDao; // = new PhoneDao(); --> 자동으로 이 기능을 실행해준다.

//	list --------------------------------------------------------------------------------------------

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST }) // --> 주소 체계
	public String list(Model model) {

		List<PersonVo> pList = phoneDao.getPersonList();

		model.addAttribute("pList", pList);

		return "list"; // return은 jsp를 알려주는 곳
	}

//	writeForm ---------------------------------------------------------------------------------------

	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {

		return "writeForm";
	}

//	write -------------------------------------------------------------------------------------------

	// 1번째방법
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(@ModelAttribute PersonVo personVo) {

		phoneDao.personInsert(personVo);

		return "redirect:/phone/list"; // --> 이렇게 하면 위의 list 명령어로 보내집니다. 주소체계로 입력해야 합니다.
	}

	// 2번째 방법 (선호하지 않음, Vo에 새로 생성자를 만드는 방법과 아래와 같이 Map을 이용한 방법이 있음)
	@RequestMapping(value = "/write2", method = RequestMethod.GET)
	public String write2(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {

		phoneDao.personInsert2(name, hp, company);

		return "redirect:/phone/list";
	}

//	updateForm --------------------------------------------------------------------------------------

	// 1번째 방법
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @RequestParam("personId") int personId) {

		PersonVo personVo = phoneDao.getPerson(personId);
		model.addAttribute("personVo", personVo);

		return "updateForm";
	}

	// 2번째 방법
	@RequestMapping(value = "/updateForm2", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm2(Model model, @RequestParam("personId") int personId) {

		Map<String, Object> personMap = phoneDao.getPerson2(personId);

		model.addAttribute("personMap", personMap);

		return "updateForm2";
	}

//	update ------------------------------------------------------------------------------------------

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo personVo) {

		phoneDao.personUpdate(personVo);

		return "redirect:/phone/list";
	}

//	delete ------------------------------------------------------------------------------------------

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("personId") int personId) {

		phoneDao.personDelete(personId);

		return "redirect:/phone/list";

	}

}
