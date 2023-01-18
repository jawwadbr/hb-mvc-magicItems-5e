package com.jawbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jawbr.dao.MagicItemsDAO;
import com.jawbr.entity.MagicItems;

public class MagicItemsServiceImpl implements MagicItemsService {

	// Injetar o DAO
	@Autowired
	private MagicItemsDAO magicItemsDAO;
	
	@Override
	@Transactional
	public List<MagicItems> getMagicItems() {
		return magicItemsDAO.getMagicItems();
	}

}
