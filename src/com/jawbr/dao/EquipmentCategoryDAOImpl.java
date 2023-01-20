package com.jawbr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jawbr.entity.EquipmentCategory;

@Repository
public class EquipmentCategoryDAOImpl implements EquipmentCategoryDAO {

	// Comes from the xml config sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<EquipmentCategory> getEquipmentCategory() {
		
		// get current session
		Session session =  sessionFactory.getCurrentSession();
		
		// Query
		Query<EquipmentCategory> q = session.createQuery("from EquipmentCategory", EquipmentCategory.class);
		
		// resultList
		List<EquipmentCategory> equips = q.getResultList();
		
		return equips;
	}

	@Override
	public EquipmentCategory getEquipmentCategory(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(EquipmentCategory.class, id);
	}

}
