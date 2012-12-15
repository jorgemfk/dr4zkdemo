/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service.util;

import javax.servlet.ServletContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Desktop;

/**
 *
 * @author JLMR
 */
public class WebServiceLocator {

    public static Object getBean(Class clazz, Desktop desk){
        return getBean(clazz,(ServletContext)desk.getWebApp().getNativeContext());
    }

    public static Object getBean(Class clazz, ServletContext context){
        return WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean(clazz.getSimpleName());
    }

}
