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

	// Vem do xml de config bean sessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<SourceBook> getSourceBook() {
		
		// Pegar a session atual
		Session session =  sessionFactory.getCurrentSession();
				
		// Query para pegar todos os sourceBooks
		Query<SourceBook> q = session.createQuery("from SourceBook", SourceBook.class);
				
		// Pegar todos os items
		List<SourceBook> sources = q.getResultList();
		
		return sources;
	}

}
