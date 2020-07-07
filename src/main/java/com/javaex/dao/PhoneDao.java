package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체 리스트--------------------------------------------------------------------------------

	public List<PersonVo> getPersonList() {

		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");

		return personList;
	}

	// 사람 데이터 추가------------------------------------------------------------------------------

	// 1번째 방법
	public int personInsert(PersonVo personVo) {
		int count = sqlSession.insert("phonebook.insert", personVo);
		return count;
	}

	// 2번째 방법(Vo에 새로 생성자를 만드는 방법과 아래와 같이 Map을 이용한 방법이 있음)
	public int personInsert2(String name, String hp, String company) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("name", name);
		pMap.put("hp", hp);
		pMap.put("company", company);

		pMap.get(name);
		pMap.get(hp);
		pMap.get(company);
		int count = sqlSession.insert("phonebook.insert2", pMap);

		return count;
	}

	// 데이터 하나 불러오기(수정할 때)---------------------------------------------------------------------

	// 1번째 방법
	public PersonVo getPerson(int personId) {
		PersonVo personVo = sqlSession.selectOne("phonebook.selectById", personId);
		return personVo;
	}

	// 2번째 방법
	public Map<String, Object> getPerson2(int personId) {
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectById2", personId);

		personMap.get("PERSON_ID");
		personMap.get("NAME");
		personMap.get("HP");
		personMap.get("COMPANY");
		return personMap;
	}

	// 사람 데이터 수정--------------------------------------------------------------------------------

	public int personUpdate(PersonVo personVo) {
		int count = sqlSession.update("phonebook.update", personVo);

		return count;
	}

	// 사람 데이터 삭제-------------------------------------------------------------------------------

	public int personDelete(int personId) {
		int count = sqlSession.delete("phonebook.delete", personId);

		return count;
	}

}