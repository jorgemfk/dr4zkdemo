/*
*
*
* Copyright (C) 2011-2012 Jorge Luis Martinez Ramirez
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
package mx.test.dr4zkdemo.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import mx.dr.forms.view.DRRender;
import mx.dr.forms.view.render.DRHtmlRender;
/**
* Example of Custom annotation  implementation component for DR4ZK, will render a  URL Link as button on view.
 * @author Jorge Luis Martinez Ramirez
 * @version 1.0
 * @since 03/02/2013
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@DRRender(itemRenderer=DRLinkRender.class)
public @interface DRLink{
	/**
	 * absolute path to image in application
	 * @return button image path 
	 */
    String image();
}
