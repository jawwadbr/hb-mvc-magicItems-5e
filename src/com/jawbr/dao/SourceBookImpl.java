package com.jawbr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jawbr.entity.SourceBook;

@Repository
public class SourceBookImpl implements SourceBookDAO {

	// Comes from the xml config sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<SourceBook> getSourceBook() {
		
		// get current session
		Session session =  sessionFactory.getCurrentSession();
				
		// Query to get all source book
		Query<SourceBook> q = session.createQuery("from SourceBook", SourceBook.class);
				
		// get result list
		List<SourceBook> sources = q.getResultList();
		
		return sources;
	}

}
