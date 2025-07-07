package com.sinse.hiberasync.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sinse.hiberasync.exception.StoreException;
import com.sinse.hiberasync.hibernate.HibernateConfig;
import com.sinse.hiberasync.model.Store;

public class StoreDAO {
	HibernateConfig config=HibernateConfig.getInstance();
	
	//한건 넣기!!!
	public void insert(Store store) throws StoreException{
		Transaction tx=null;
		
		try(Session session=config.getSession() ){
			tx=session.beginTransaction();
			session.save(store);				
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();
			throw new StoreException("등록실패", e);
		}
	}
}









