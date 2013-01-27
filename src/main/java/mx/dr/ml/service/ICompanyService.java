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

import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.test.vo.Company;
import mx.test.vo.User;

/**
 * Company Service.
 * @author jorge
 *
 */
public interface ICompanyService {
		/**
		 * get company by email.
		 * @param clave email key
		 * @return Company founded.
		 * @throws Exception
		 */
        public User companyByKey(String clave) throws Exception;
        /**
         * Save a new company.
         * @param dto dr4zk view form valued object.
         * @throws Exception
         */
        public void saveNewCompany(GenericDtoIN dto) throws Exception;
        /**
         * update a company
         * @param dto dr4zk view form valued object.
         * @throws Exception
         */
        public void updateCompany(GenericDtoIN dto) throws Exception;
        /**
         * find company by id
         * @param dto dr4zk object with the parameter to search.
         * @return founded Company.
         * @throws Exception
         */
        public Company companyById(GenericDtoOneIN dto) throws Exception;
}
