package mall.model.category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mall.domain.TopCategory;

@Repository
public class HibernateTopCategoryDAO implements TopCategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List selectAll() {
		Query query=sessionFactory.getCurrentSession().createQuery("from TopCategory", TopCategory.class);
		return query.getResultList();
	}

	@Override
	public TopCategory select(int topcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
