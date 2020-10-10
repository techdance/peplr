package com.collaborated.entity.service.persistence.impl;

import com.collaborated.entity.model.labDetailedCourseIdentification;
import com.collaborated.entity.model.impl.labDetailedCourseIdentificationImpl;
import com.collaborated.entity.service.persistence.labDetailedCourseIdentificationFinder;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

public class labDetailedCourseIdentificationFinderImpl extends labDetailedCourseIdentificationFinderBaseImpl implements labDetailedCourseIdentificationFinder{
	public labDetailedCourseIdentification getCourseIdentificationbyProjectId(long projectId){
		/*Session session=null;
		try{
			//open ORM Session
			session=openSession();
			//get sql query return in default.xml
			String sql=CustomSQLUtil.get(getClass(),"getCourseIdentificationbyProjectId");
			SQLQuery sqlQuery=session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
            //Add entity to be searched
			sqlQuery.addEntity("labDetailedCourseIdentification",labDetailedCourseIdentificationImpl.class);
			//Replace positional parameters in the query
            QueryPos queryPos=QueryPos.getInstance(sqlQuery);
            queryPos.add(projectId);
            //Execute query and return result
                 return (labDetailedCourseIdentification)sqlQuery.list();
		}catch(Exception e){
   
		}finally {
			closeSession(session);
		}*/
		return null;
	}
}
