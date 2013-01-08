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
package mx.dr.ml.servlet;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import mx.dr.ml.service.ICatalogService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.vo.CatalogStatus;
import mx.test.vo.Category;
import mx.test.vo.Contract;
import mx.test.vo.MainCategory;
import mx.test.vo.City;

/**
 *
 * @author pcSS
 */
public class InitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet Context is initialized....");
        Thread th = new TempThread(sce.getServletContext());
        th.start();
    }

    public void contextDestroyed(ServletContextEvent sce) {
       System.out.println("Servlet Context is destroyed....");
    }

    private class TempThread extends Thread{
        ServletContext servletContext;

        public TempThread(ServletContext servletContext) {
            super();
            this.servletContext = servletContext;
        }


        public void run() {
            System.out.println("Hilo de temporales....");
            ICatalogService  service =(ICatalogService)  WebServiceLocator.getBean(ICatalogService.class, servletContext);
            try {
                MainCategory cat = new MainCategory();
                cat.setEstatusEnum(CatalogStatus.ACTIVE);
                cat.setRegistryDate(new Date());
                cat.setName("Restaurant");
                service.save(cat);
                
                cat = new MainCategory();
                cat.setEstatusEnum(CatalogStatus.ACTIVE);
                cat.setRegistryDate(new Date());
                cat.setName("Bar");
                service.save(cat);
                
                Category c= new Category();
                c.setEstatusEnum(CatalogStatus.ACTIVE);
                c.setName("Kareoke");
                c.setFather(cat);
                service.save(c);
                
                City estado= new City();
                estado.setName("Estado de Mexico");
                estado.setCountry("MX");
                estado.setVisible(Boolean.TRUE);
                service.save(estado);
                
                estado= new City();
                estado.setName("Mexico Distrito Federal");
                estado.setCountry("MX");
                estado.setVisible(Boolean.TRUE);
                service.save(estado);
                
                Contract contract = new Contract();
                contract.setType("E");
                contract.setContent("USER CONTRACT HERE...");
                service.save(contract);    
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(InitListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
