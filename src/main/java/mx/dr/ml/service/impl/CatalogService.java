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
import mx.dr.ml.service.ICatalogService;
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
@Service("ICatalogService")
public class CatalogService implements ICatalogService {

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

    @Transactional
    public List find(Class myClass, String field , Object val){
    	return dao.find(myClass, field, val);
    }
    
    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }
}
