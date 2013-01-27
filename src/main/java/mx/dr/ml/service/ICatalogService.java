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
package mx.dr.ml.service;

import java.util.List;
import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;

/**
 * Service of generic CRUD actions.
 * @author jorge
 *
 */
public interface ICatalogService {
	/**
	 * Save a object or a list of objects valued from a view form.
	 * @param dto dr4zk object that encapsulates the result of a form value.
	 * @throws Exception if error
	 */
    public void save(GenericDtoIN dto) throws Exception;
    /**
     * Save a persistent object
     * @param o the object to persist
     * @throws Exception if any error
     */
    public void save(Object o) throws Exception;
    /**
     * find by id
     * @param dto  dr4zk object that encapsulates the parameter to search a object.
     * @return unique object
     * @throws Exception if error
     */
    public Object boById(GenericDtoOneIN dto) throws Exception;
    /**
     * find by id
     * @param clazz class of object to find.
     * @param id object unique identifier
     * @return unique object
     * @throws Exception
     */
    public <T extends Object>T boById(Class clazz, Object id) throws Exception;
    /**
     * find by a view form object valued
     * @param dto dr4zk object with values with the search parameters
     * @return list of results.
     * @throws Exception if error.
     */
    public List findByExampleDTO(GenericDtoIN  dto) throws Exception;
    /**
     * find by a single attribute
     * @param myClass class to search
     * @param field name of the attribute
     * @param val value attribute to search
     * @return list of results
     * @throws Exception if error
     */
    public List find(Class myClass, String field , Object val) throws Exception;
    /**
     * find by a list by a example object valued
     * @param vo persistence object valued
     * @param limit max results
     * @param order attributes ordered by
     * @return list of results.
     * @throws Exception if error
     */
    public List<? extends Object> findByExampleDesc(Object vo, int limit, String... order) throws Exception;
        
}
