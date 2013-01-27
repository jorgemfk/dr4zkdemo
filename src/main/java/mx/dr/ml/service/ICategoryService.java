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
import mx.test.vo.Category;

/**
 * service for business categories
 * @author jorge
 *
 */
public interface ICategoryService {
	/**
	 * find active categories.
	 * @return category list.
	 * @throws Exception
	 */
    public List findActive() throws Exception;
    /**
     * find all categories
     * @return categories list
     * @throws Exception
     */
    public List findAll() throws Exception;
    /**
     * find all man categories
     * @return main categories list.
     * @throws Exception
     */
    public List findMainCategory() throws Exception;
    /**
     * save category by name
     * @param value name of the category to save.
     * @return category created.
     * @throws Exception
     */
    public Category save(String value) throws Exception;
}
