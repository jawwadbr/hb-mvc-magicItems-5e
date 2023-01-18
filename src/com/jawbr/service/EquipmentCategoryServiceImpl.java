package com.jawbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jawbr.dao.EquipmentCategoryDAO;
import com.jawbr.entity.EquipmentCategory;

public class EquipmentCategoryServiceImpl implements EquipmentCategoryService {

	// Injetar DAO
	@Autowired
	private EquipmentCategoryDAO equipmentCategoryDAO;
	
	@Override
	@Transactional
	public List<EquipmentCategory> getEquipmentCategory() {
		return equipmentCategoryDAO.getEquipmentCategory();
	}

}
