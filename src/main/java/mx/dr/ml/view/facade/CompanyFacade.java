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
package mx.dr.ml.view.facade;

import mx.dr.forms.dto.GenericDtoIN;
import mx.dr.forms.dto.GenericDtoOneIN;
import mx.dr.ml.service.ICompanyService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.dr4zkdemo.view.model.RegisterCompanyContact;
import mx.test.dr4zkdemo.view.model.RegisterCompanyMain;
import mx.test.vo.Company;
import mx.test.vo.User;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author JLMR
 */
public class CompanyFacade {



    public void saveNewCompany(GenericDtoIN dto) throws Exception {
        ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
        service.saveNewCompany(dto);
    }


    public void updateCompany(GenericDtoIN dto) throws Exception {
        ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
        service.updateCompany(dto);
    }

    public Company companyById(GenericDtoOneIN dto) throws Exception {
        ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
        return service.companyById(dto);
    }


    public boolean companyByKey(RegisterCompanyContact dto) throws Exception {
        ICompanyService service = (ICompanyService) WebServiceLocator.getBean(ICompanyService.class, Executions.getCurrent().getDesktop());
        return service.companyByKey(dto.getKey())==null;
    }

}
