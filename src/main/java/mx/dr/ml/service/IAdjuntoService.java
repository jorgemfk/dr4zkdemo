/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.dr.ml.service;

import mx.test.vo.Adjunto;
import org.zkoss.util.media.Media;

/**
 *
 * @author JLMR
 */
public interface IAdjuntoService {
        public Long saveMedia(Media media, Adjunto adjunto) throws Exception;
        public void writeTempFiles() throws Exception;
}
