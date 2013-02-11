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
package mx.test.dr4zkdemo.custom;

import mx.dr.forms.view.render.IDRRendereable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Toolbarbutton;

/**
* Example of Custom Component compose for DR4ZK, will render a  URL Link as button on view.
 * @author Jorge Luis Martinez Ramirez
 * @version 1.0
 * @since 03/02/2013
 */
public class DRLinkRender implements IDRRendereable<DRLink,String> {
    
    /*
     * (non-Javadoc)
     * @see mx.dr.forms.view.render.IDRRendereable#render(java.lang.annotation.Annotation, java.lang.String, java.lang.Object, java.lang.Object)
     */
    public Component render(final DRLink drLink,final String name,final String value,final Object dtoValue)throws Exception {
        Toolbarbutton toolbarbutton = new Toolbarbutton();
        if (value != null) {
            toolbarbutton.setHref(value);
            toolbarbutton.setImage(drLink.image());
            toolbarbutton.setTarget("_blank");
        }
        toolbarbutton.setId(name);
        return toolbarbutton;
    }

    /*
     * (non-Javadoc)
     * @see mx.dr.forms.view.render.IDRRendereable#value(java.lang.annotation.Annotation, org.zkoss.zk.ui.Component, java.lang.Class)
     */
    public Object value(final DRLink drLink, final Component comp, final Class<String> expectedType) {
        return null;
    }

    
}
