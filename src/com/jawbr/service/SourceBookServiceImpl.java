package com.jawbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jawbr.dao.SourceBookDAO;
import com.jawbr.entity.SourceBook;

public class SourceBookServiceImpl implements SourceBookService {

	// Injectar DAO
	@Autowired
	private SourceBookDAO sourceBookDAO;
	
	@Override
	@Transactional
	public List<SourceBook> getSourceBook() {
		return sourceBookDAO.getSourceBook();
	}

}
