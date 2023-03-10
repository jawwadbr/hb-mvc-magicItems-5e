package com.jawbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jawbr.dao.EquipmentCategoryDAO;
import com.jawbr.entity.EquipmentCategory;

@Service
public class EquipmentCategoryServiceImpl implements EquipmentCategoryService {

	// Inject DAO
	@Autowired
	private EquipmentCategoryDAO equipmentCategoryDAO;
	
	@Override
	@Transactional
	public List<EquipmentCategory> getEquipmentCategory() {
		return equipmentCategoryDAO.getEquipmentCategory();
	}

	@Override
	@Transactional
	public EquipmentCategory getEquipmentCategory(int id) {
		return equipmentCategoryDAO.getEquipmentCategory(id);
	}

}
