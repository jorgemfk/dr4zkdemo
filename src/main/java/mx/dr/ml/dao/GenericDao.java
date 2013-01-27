/*
*
*
* Copyright (C) 2012 Jorge Luis Martinez Ramirez
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
* Author: Jorge Luis Martinez Ramirez
* Email: jorgemfk1@gmail.com
*/
package mx.dr.ml.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import javax.annotation.Resource;
import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.utils.DRBOFieldTranslator;
import mx.dr.forms.view.utils.DRFormBuilder;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.dto.DRFieldDto;
import mx.dr.forms.view.DRField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Generic DAO class for CRUD actions.
 * @author jorge
 *
 */
@Repository("GenericDao")
public class GenericDao extends HibernateTemplate implements Serializable {

	/**
	 * for SessionFactory injection.
	 */
    @Resource(name = "sessionFactory")
    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * getting the current session.
     */
    public Session getSession(){
        return super.getSession();
    }
    /**
     *
     */
    private static final long serialVersionUID = -2827312197658379736L;

    /**
     * The current session to get
     * @return current session.
     */
    protected Session currentSession() {
        return getSession();

    }

    /**
     * save or update action
     * @param o object to save
     */
    public void saveOrUpdate(Object o) {
        Session sess = currentSession();
        sess.saveOrUpdate(o);
    }

    /**
     * delete action
     * @param o object to delete
     */
    public void delete(Object o) {
        Session sess = currentSession();
        sess.delete(o);
    }

    /**
     * search by id
     * @param aclass class type to search.
     * @param id identifier to find.
     * @return object founded.
     */
    public Object findById(Class aclass, Object id) {
        Session sess = currentSession();
        return sess.load(aclass, (Serializable) id);
    }

    /**
     * search all records.
     * @param aclass class type to search.
     * @return list of object results
     */
    public List findAll(Class aclass) {
        Session sess = currentSession();
        return sess.createCriteria(aclass).list();
    }

    /**
     * find by example on a valued persistent vo
     * @param vo valued object to be swept in their attributes
     * @param limit max results
     * @param order attribute ordered by
     * @return ascendent list result ordered.
     * @throws Exception if any error.
     */
    public List findByExample(Object vo, int limit, String... order) throws Exception {
        return criteriaByExample(vo, false, limit, true, order).list();
    }

    /**
     * find by example on a valued persistent vo
     * @param vo valued object to be swept in their attributes
     * @param limit max results
     * @param order attribute ordered by
     * @return descendant list result ordered.
     * @throws Exception if any error.
     */
    public List findByExampleDesc(Object vo, int limit, String... order) throws Exception {
        return criteriaByExample(vo, false, limit, false, order).list();
    }

    /**
     * find unique result on a valued persistent vo
     * @param vo valued object to be swept in their attributes
     * @return object funded.
     * @throws Exception if any error
     */
    public Object findUniqueByExample(Object vo) throws Exception {
        return (Object) criteriaByExample(vo, false, 0, true).uniqueResult();
    }

    /**
     * find by example on a valued view dto
     * @param vo valued object to be swept in their attributes
     * @param limit max results
     * @param order attribute ordered by
     * @return ascendent list result ordered.
     * @throws Exception if any error.
     */
    public List findByExampleDTO(Object vo, int limit, String... order) throws Exception {
    	System.out.println("vo:"+vo);
        return criteriaByExample(vo, true, limit, true, order).list();
    }

    /**
     * find by example on a valued view dto
     * @param vo valued object to be swept in their attributes
     * @param limit max results
     * @param order attribute ordered by
     * @return descendant list result ordered.
     * @throws Exception if any error.
     */
    public List findByExampleDTODesc(Object vo, int limit, String... order) throws Exception {
        return criteriaByExample(vo, true, limit, false, order).list();
    }

    /**
     * find unique result on a valued view dto
     * @param vo valued object to be swept in their attributes
     * @return object funded.
     * @throws Exception if any error
     */
    public Object findUniqueByExampleDTO(Object vo) throws Exception {
        return (Object) criteriaByExample(vo, true, 0, true).uniqueResult();
    }
    /**
     * only one equal attribute to search.
     * @param myClass class to search.
     * @param field attribute name to search
     * @param val attribute value to search
     * @return list of results.
     */
    public List find(Class myClass, String field , Object val){
    	Criteria c = currentSession().createCriteria(myClass);
    	c.add(Restrictions.eq(field, val));
    	return c.list();
    }


    /**
     * Primary method for the generation of dynamic criteria.
     * @param vo valued object to be swept in their attributes
     * @param isDto is a view dto not a persistence class.
     * @param limit max results number.
     * @param isAsc is ascendent
     * @param order attributes orders by.
     * @return prepared criteria.
     * @throws Exception if any error.
     */
    protected Criteria criteriaByExample(Object vo, boolean isDto, int limit, boolean isAsc, String... order) throws  Exception{
        Class myClass = null;
        if (isDto) {
        	System.out.println(vo);
        	System.out.println(vo.getClass().getAnnotation(DRRootEntity.class));
            DRRootEntity drRootEntity = vo.getClass().getAnnotation(DRRootEntity.class);
            myClass = drRootEntity.entity();
        } else {
            myClass = vo.getClass();

        }
        Criteria c = currentSession().createCriteria(myClass);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteriaOnReflect(c, vo);
        if (order != null) {
            for (String s : order) {
                c.addOrder(isAsc ? Order.asc(s) : Order.desc(s));
            }
        }
        if (limit > 0) {
            c.setMaxResults(limit);
        }
        return c;
    }

    /**
     * recursive method for criteria generation.
     * @param c result criteria 
     * @param vo valued object to be swept in their attributes
     */
    protected void criteriaOnReflect(Criteria c, Object vo) throws Exception{

        Object value = null;
        DRField.Operator operation = null;
        DRField criterio = null;
        String fName = null;
        Field m;
        for (DRFieldDto mdto : DRFormBuilder.getDRFields(vo.getClass(), FormActions.SEARCH)) {

                m=mdto.getField();
                m.setAccessible(true);
                value = m.get(vo);

                if (value != null) {

                    //TODO implementar para todos los tipos de objeto no relacionado en tabla si no tronara
                    //if (value instanceof Integer || value instanceof Long || value instanceof Double || value instanceof Float || value instanceof Boolean || value instanceof BigDecimal || value instanceof String || value instanceof Date || value instanceof DRBOFieldTranslator) {
                    //TODO implementar para mas operaciones

                    criterio = mdto.getDrField();
                    if (criterio != null) {
                        operation = criterio.searchOperador();
                        if (value instanceof DRBOFieldTranslator) {
                            fName = ((DRBOFieldTranslator) value).getFieldName();
                            value = ((DRBOFieldTranslator) value).getFieldValue();
                        } else {
                            fName = m.getName();
                        }
                        if (operation != null) {
                            if (operation.equals(DRField.Operator.EQUALS)) {
                                c.add(Restrictions.eq(fName, value));
                            } else if (operation.equals(DRField.Operator.LIKE)) {
                                c.add(Restrictions.ilike(fName, "%" + value + "%"));
                            } else {
                                System.out.println("operator not implemented");

                            }

                        } else {
                            System.out.println("default operator no aplicado");
                            //c.add(Restrictions.eq(map.get("atributte"), value));
                        }


                    }
                }// else {
                //    criteriaOnReflect(c.createCriteria(m.getName()), value);
                //}
            }
        }


}
