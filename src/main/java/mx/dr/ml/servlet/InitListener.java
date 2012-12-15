/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.servlet;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import mx.dr.ml.service.ICatalogoService;
import mx.dr.ml.service.util.WebServiceLocator;
import mx.test.vo.CatalogStatus;
import mx.test.vo.Categoria;
import mx.test.vo.CategoriaMain;
import mx.test.vo.Estado;

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
            ICatalogoService  service =(ICatalogoService)  WebServiceLocator.getBean(ICatalogoService.class, servletContext);
            try {
                CategoriaMain cat = new CategoriaMain();
                cat.setEstatusEnum(CatalogStatus.ACTIVE);
                cat.setFechaAlta(new Date());
                cat.setNombre("Restaurant");
                service.save(cat);
                
                cat = new CategoriaMain();
                cat.setEstatusEnum(CatalogStatus.ACTIVE);
                cat.setFechaAlta(new Date());
                cat.setNombre("Bar");
                service.save(cat);
                
                Categoria c= new Categoria();
                c.setEstatusEnum(CatalogStatus.ACTIVE);
                c.setNombre("Canta Bar");
                c.setPadre(cat);
                service.save(c);
                
                Estado estado= new Estado();
                estado.setNombre("Estado de Mexico");
                estado.setPais("MX");
                estado.setVisible(Boolean.TRUE);
                service.save(estado);
                
                estado= new Estado();
                estado.setNombre("Mexico Distrito Federal");
                estado.setPais("MX");
                estado.setVisible(Boolean.TRUE);
                service.save(estado);
                
                        
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(InitListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
