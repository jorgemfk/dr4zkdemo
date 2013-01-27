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
package mx.dr.ml.service.util;

import javax.servlet.ServletContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Desktop;

/**
 * Spring service locator
 * @author jorge
 *
 */
public class WebServiceLocator {

	/**
	 * Get Spring Service Bean Instance
	 * @param clazz Service class
	 * @param desk ZK desktop
	 * @return Service Instance
	 */
    public static <T extends Object>T getBean(Class clazz, Desktop desk){
        return getBean(clazz,(ServletContext)desk.getWebApp().getNativeContext());
    }

    /**
     * Get Spring Service Bean Instance
     * @param clazz Service class
     * @param context application sevlet context
     * @return service Instance
     */
    public static <T extends Object>T getBean(Class clazz, ServletContext context){
        return (T)WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean(clazz.getSimpleName());
    }

}
