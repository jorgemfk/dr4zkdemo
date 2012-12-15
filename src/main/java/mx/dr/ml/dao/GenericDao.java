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

@Repository("GenericDao")
public class GenericDao extends HibernateTemplate implements Serializable {

    @Resource(name = "sessionFactory")
    @Autowired(required = true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public Session getSession(){
        return super.getSession();
    }
    /**
     *
     */
    private static final long serialVersionUID = -2827312197658379736L;

    protected Session currentSession() {
        return getSession();

    }

    public void saveOrUpdate(Object o) {
        Session sess = currentSession();
        sess.saveOrUpdate(o);
    }

    public void delete(Object o) {
        Session sess = currentSession();
        sess.delete(o);
    }

    public Object findById(Class aclass, Object id) {
        Session sess = currentSession();
        return sess.load(aclass, (Serializable) id);
    }

    public List findAll(Class aclass) {
        Session sess = currentSession();
        return sess.createCriteria(aclass).list();
    }

    public List findByExample(Object vo, int limit, String... order) throws Exception {
        return criteriaByExample(vo, false, limit, true, order).list();
    }

    public List findByExampleDesc(Object vo, int limit, String... order) throws Exception {
        return criteriaByExample(vo, false, limit, false, order).list();
    }

    public Object findUniqueByExample(Object vo) throws Exception {
        return (Object) criteriaByExample(vo, false, 0, true).uniqueResult();
    }

    public List findByExampleDTO(Object vo, int limit, String... order) throws Exception {
        return criteriaByExample(vo, true, limit, true, order).list();
    }

    public List findByExampleDTODesc(Object vo, int limit, String... order) throws Exception {
        return criteriaByExample(vo, true, limit, false, order).list();
    }

    public Object findUniqueByExampleDTO(Object vo) throws Exception {
        return (Object) criteriaByExample(vo, true, 0, true).uniqueResult();
    }

    /**
     * Metodo principal para la generacion del criteria dinamico
     * @param instancia objeto valuado a ser barrido en sus atributos
     * @return criteria para ser tratado
     */
    protected Criteria criteriaByExample(Object vo, boolean isDto, int limit, boolean isAsc, String... order) throws  Exception{
        Class myClass = null;
        if (isDto) {
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
     * Metodo recursivo
     * @param c criteria devuelto para su tratamiento
     * @param instancia objeto valuado a ser barrido en sus atributos
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
