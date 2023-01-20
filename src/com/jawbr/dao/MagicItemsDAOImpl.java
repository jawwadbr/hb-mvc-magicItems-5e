package com.jawbr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jawbr.entity.MagicItems;

@Repository
public class MagicItemsDAOImpl implements MagicItemsDAO {

	// Comes from the xml config sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	// Transactional will be made from the Service Layer
	public List<MagicItems> getMagicItems() {
		
		// get current session
		Session session =  sessionFactory.getCurrentSession();
		
		// Query to get all items
		Query<MagicItems> q = session.createQuery("from MagicItems", MagicItems.class);
		
		// get result list
		List<MagicItems> items = q.getResultList();
		
		return items;
	}

	@Override
	public MagicItems getMagicItems(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(MagicItems.class ,id);
	}

	@Override
	public void saveMagicItem(MagicItems item) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(item);
	}

	@Override
	public void deleteMagicItem(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		MagicItems delItem = getMagicItems(id);
		
		session.delete(delItem);
		
	}

}
