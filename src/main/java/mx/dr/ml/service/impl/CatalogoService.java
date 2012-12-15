package mx.dr.ml.service.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.test.vo.CatalogStatus;
import mx.dr.ml.dao.GenericDao;
import mx.dr.ml.service.ICatalogoService;
import mx.dr.util.ReflectionUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("ICatalogoService")
public class CatalogoService implements ICatalogoService {

    @Resource(name = "GenericDao")
    private GenericDao dao;

    @Transactional
    public void save(Object o) throws Exception {
        dao.saveOrUpdate(o);
    }

    @Transactional
    public void save(GenericDtoIN dto) throws Exception {
        for (Object o : dto.getBos()) {

            if (ReflectionUtils.genericGet(o, "status") == null) {
                ReflectionUtils.genericSet(o, "status", CatalogStatus.ACTIVE.getId());
                ReflectionUtils.genericSet(o, "fechaAlta", Calendar.getInstance().getTime());
            }
            System.out.println(o);
            dao.saveOrUpdate(o);
        }

    }

    
    @Transactional
    public Object boById(GenericDtoOneIN dto) throws Exception {
        Object com;
        Object id = null;
        try {
            id = Integer.valueOf((String) dto.getParam());
        } catch (Exception e) {
            id = dto.getParam();
        }
        com = dao./*findById*/get(dto.getAclass(),(Serializable) id);

        System.out.println(com);
        return com;
    }

    @Transactional
    public Object boById(Class clazz, Object id) throws Exception {
        Object o = dao.get(clazz,(Serializable) id);
        System.out.println(o);
        return o;
    }

    @Transactional
    public List findByExampleDTO(GenericDtoIN dto) throws Exception {
        List res = dao.findByExampleDTO(dto.getViewDTO(), 0);
        System.out.println(res);
        return res;
    }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }
}
