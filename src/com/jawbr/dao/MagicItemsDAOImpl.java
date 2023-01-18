package com.jawbr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.jawbr.entity.MagicItems;

public class MagicItemsDAOImpl implements MagicItemsDAO {

	// Vem do xml de config bean sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	// Transactional vai ser feito pelo Service Layer
	public List<MagicItems> getMagicItems() {
		
		// Pegar a session atual
		Session session =  sessionFactory.getCurrentSession();
		
		// Query para pegar todos os items
		Query<MagicItems> q = session.createQuery("from magic_items", MagicItems.class);
		
		// Pegar todos os items
		List<MagicItems> items = q.getResultList();
		
		return items;
	}

}
