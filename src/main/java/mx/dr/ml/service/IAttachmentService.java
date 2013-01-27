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
package mx.dr.ml.service;

import mx.test.vo.Attachment;
import org.zkoss.util.media.Media;

/**
 * File utilities
 * @author jorge
 *
 */
public interface IAttachmentService {
	    /**
	     * save a uploaded document.
	     * @param media ZK media object
	     * @param adjunto document to save.
	     * @return generated id
	     * @throws Exception
	     */
        public Long saveMedia(Media media, Attachment adjunto) throws Exception;
        /**
         * write all saved documents on a directory.
         * @throws Exception if any error.
         */
        public void writeTempFiles() throws Exception;
}
