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
package mx.dr.ml.service.impl;

import java.io.ByteArrayInputStream;
import java.util.List;
import javax.annotation.Resource;
import mx.dr.ml.dao.GenericDao;
import mx.dr.util.FileUtils;
import mx.dr.ml.service.IAttachmentService;
import mx.test.vo.Attachment;
import mx.test.vo.Document;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zkoss.util.media.Media;
import org.zkoss.util.resource.Labels;

/**
 *
 * @author JLMR
 */
@Scope("prototype")
@Service("IAttachmentService")
public class AttachmentService implements IAttachmentService {

    @Resource(name = "GenericDao")
    private GenericDao dao;

    @Transactional
    public Long saveMedia(Media media, Attachment adjunto) throws Exception {
        String res = "/empty.properties";
        Document doc = new Document();
        doc.setDataContent(media.getByteData());
        dao.save(doc);
        FileUtils.writeToFile(Attachment.class.getResource(res).getPath().replaceFirst(res, "") + "/../../" + Labels.getLabel("parametro.adjuntos.folder") + "/" + doc.getId() + "." + adjunto.getFormat(), media.getStreamData());
        System.out.println(Attachment.class.getResource(res).getPath().replaceFirst(res, "") + "/../../" + Labels.getLabel("parametro.adjuntos.folder") + "/" + doc.getId() + "." + adjunto.getFormat());
       
        return doc.getId();
    }

     @Transactional
     public void writeTempFiles() throws Exception{
         String res = "/empty.properties";
         List<Attachment> ids = dao.find("from Attachment");
         Document doc;
         for(Attachment adjunto :ids){
             doc = dao.get(Document.class, adjunto.getIddocument());
             if(doc!=null)
                FileUtils.writeToFile(Attachment.class.getResource(res).getPath().replaceFirst(res, "") + "/../../" + Labels.getLabel("parametro.adjuntos.folder") + "/" + doc.getId() + "." + adjunto.getFormat(),new ByteArrayInputStream(doc.getDataContent()));
         }
         System.gc();
     }

    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }
}
