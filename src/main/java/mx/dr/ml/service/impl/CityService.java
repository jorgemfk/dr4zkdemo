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

import java.util.List;
import javax.annotation.Resource;
import mx.dr.ml.dao.GenericDao;
import mx.dr.ml.service.ICityService;
import mx.test.vo.City;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * city service implementation
 * @author jorge
 *
 */
@Scope("prototype")
@Service("ICityService")
public class CityService implements ICityService{
	/**
	 * generic dao
	 */
    @Resource(name="GenericDao")
    private GenericDao dao;

    /**
     * @see mx.dr.ml.service.ICityService#findMXCities()
     */
    @Transactional
    public List<City> findMXCities() throws Exception {
        City estado= new City("MX");
        return dao.findByExample(estado,0, "name");
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
