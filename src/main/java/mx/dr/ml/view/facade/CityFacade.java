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

import java.util.List;
import mx.dr.forms.dto.GenericDtoParamsIN;
import mx.dr.forms.view.component.DRListBox;
import mx.dr.ml.service.ICityService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.vo.City;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;

/**
 * A facade is recommended as necessary pattern to implement since dr4zk will make an instance of this.
 * City facade 
 * @author jorge
 */
public class CityFacade  {

	/**
     * @see mx.dr.ml.service.ICityService#findMXCities()
     */
    public List<City> findMXCities() throws Exception {
        Desktop desk = Executions.getCurrent().getDesktop();
        ICityService service = (ICityService) WebServiceLocator.getBean(ICityService.class, desk);
        return service.findMXCities();
    }

}
