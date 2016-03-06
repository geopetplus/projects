package com.geopetplusadmin.domain.utility;

public class CommonUtils {

	public String generateFacilityId(String facilityName, String facilityOwner) {
		
		String facilityId = "P".concat(facilityName.substring(0, 3))
				.concat(facilityOwner.substring(0, 2)).toUpperCase();
		
		/*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.eq(UniqueFacilityId, userid));*/
		
		/*List l = getHibernateTemplate().find("from login l where l.facilityid = ?", facilityId);
		if(l.size()>0) {
			System.out.println("Step 1: l="+l);
			System.out.println("Step 2: l.size="+l.size());
		} else {
			System.out.println("Step 3: l size < 0");
		}*/
		
		return facilityId;
	}
		
}
