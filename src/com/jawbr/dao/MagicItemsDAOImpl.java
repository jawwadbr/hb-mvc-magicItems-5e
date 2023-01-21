package com.jawbr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jawbr.entity.MagicItems;
import com.jawbr.util.SortUtil;

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
	public List<MagicItems> getMagicItems(String sortField) {
		
		Session session = sessionFactory.getCurrentSession();
		
		// determine sort field
		String fieldName = null;
		
		switch (sortField) {
		case SortUtil.ITEM_NAME: {
			fieldName = SortUtil.ITEM_NAME;
			break;
		}
		case SortUtil.ITEM_RARITY: {
			fieldName = SortUtil.ITEM_RARITY;
			break;
		}
		case SortUtil.ITEM_CATEGORY: {
			fieldName = SortUtil.ITEM_CATEGORY;
			break;
		}
		case SortUtil.ITEM_SOURCE_BOOK: {
			fieldName = SortUtil.ITEM_SOURCE_BOOK;
			break;
		}
		default:
			fieldName = "id";
		}
		
		// create query
		String queryString = "from MagicItems order by " + fieldName;
		
		Query<MagicItems> q = session.createQuery(queryString, MagicItems.class);
		
		// execute and get result list
		List<MagicItems> sortedItems = q.getResultList();
		
		return sortedItems;
	}

	@Override
	public MagicItems getMagicItem(int id) {
		
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
		
		MagicItems delItem = getMagicItem(id);
		
		session.delete(delItem);
		
	}

}








































