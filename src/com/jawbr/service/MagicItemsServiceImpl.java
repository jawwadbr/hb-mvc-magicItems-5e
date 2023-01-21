package com.jawbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jawbr.dao.MagicItemsDAO;
import com.jawbr.entity.MagicItems;

@Service
public class MagicItemsServiceImpl implements MagicItemsService {

	// Inject DAO
	@Autowired
	private MagicItemsDAO magicItemsDAO;
	
	@Override
	@Transactional
	public List<MagicItems> getMagicItems() {
		return magicItemsDAO.getMagicItems();
	}

	@Override
	@Transactional
	public List<MagicItems> getMagicItems(String sortField) {
		return magicItemsDAO.getMagicItems(sortField);
	}

	@Override
	@Transactional
	public MagicItems getMagicItem(int id) {
		return magicItemsDAO.getMagicItem(id);
	}

	@Override
	@Transactional
	public void saveMagicItem(MagicItems item) {
		magicItemsDAO.saveMagicItem(item);
	}

	@Override
	@Transactional
	public void deleteMagicItem(int id) {
		magicItemsDAO.deleteMagicItem(id);
	}

}
