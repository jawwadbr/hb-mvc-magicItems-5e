package com.jawbr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.jawbr.entity.EquipmentCategory;

public class EquipmentCategoryDAOImpl implements EquipmentCategoryDAO {

	// Vem do xml de config bean sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<EquipmentCategory> getEquipmentCategory() {
		
		// Pegar a session atual
		Session session =  sessionFactory.getCurrentSession();
		
		// Query
		Query<EquipmentCategory> q = session.createQuery("from equipment_category", EquipmentCategory.class);
		
		// resultList
		List<EquipmentCategory> equips = q.getResultList();
		
		return equips;
	}

}
