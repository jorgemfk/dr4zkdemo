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

import java.util.Calendar;
import mx.dr.ml.service.ICategoryService;
import java.util.List;
import javax.annotation.Resource;
import mx.test.vo.CatalogStatus;
import mx.dr.ml.dao.GenericDao;
import mx.test.vo.Category;
import mx.test.vo.MainCategory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Category service implementation
 * @author jorge
 *
 */
@Scope("prototype")
@Service("ICategoryService")
public class CategoryService implements ICategoryService{

	/**
	 * generic dao
	 */
    @Resource(name="GenericDao")
    private GenericDao dao;

    /**
     * @see mx.dr.ml.service.ICategoryService#findActive()
     */
    @Transactional
    public List findActive() throws Exception {
        List  res= dao.findByNamedParam("from Category where status=:status order by name", "status", CatalogStatus.ACTIVE.getId());
        System.out.println(res);
        return res;
    }

    /**
     * @see mx.dr.ml.service.ICategoryService#findMainCategory()
     */
     @Transactional
    public List findMainCategory() throws Exception {
        return dao.find("from MainCategory order by name");
    }
    
     /**
      * @see mx.dr.ml.service.ICategoryService#findAll()
      */
    @Transactional
    public List findAll() throws Exception {
        List  res= dao.find("from Category order by name");
        System.out.println(res);
        return res;
    }

    /**
     * @see mx.dr.ml.service.ICategoryService#save(String)
     */
    @Transactional
    public Category save(String value) throws Exception{
        Category vo = new Category();
        vo.setName(value);
        vo.setStatus(CatalogStatus.INACTIVE.getId());
        vo.setFechaAlta(Calendar.getInstance().getTime());
        vo.setFather(new MainCategory(1));
        dao.save(vo);
        return vo;
    }

	/**
	 * @return the dao
	 */
	public GenericDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(GenericDao dao) {
		this.dao = dao;
	}

    

}
