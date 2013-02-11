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
package mx.test.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import mx.dr.forms.dto.DRAttachMedia;

import org.zkoss.util.resource.Labels;

/**
 * Attachment persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_attachment")
@Inheritance(strategy = InheritanceType.JOINED)
public class Attachment implements java.io.Serializable, DRAttachMedia {

    /**
	 * serial
	 */
	private static final long serialVersionUID = -8819648112877018991L;
	/**
	 * attachment id
	 */
	private Long id;
	/**
	 * file name
	 * 
	 */
    private String name;
    /**
     * file extension format
     */
    private String format;
    /**
     * mime type
     */
    private String contentType;
    /**
     * document id
     */
    private Long iddocument;

    /**
     * default constructor
     */
    public Attachment() {
        super();
    }

    /**
     * constructor for id 
     * @param id the id
     */
    public Attachment(Long id) {
        super();
        this.id = id;
    }

    /**
     * 
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    /**
	 * @param id the id to set
	 */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the contentType
     */
    @Column(name = "tipo")
    public String getContentType() {
        return contentType;
    }

    /**
	 * @param contentType the contentType to set
	 */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
	 * @param the format
	 */
    @Column(name = "extension")
    public String getFormat() {
        return format;
    }

    /**
	 * @param format the format to set
	 */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
   	 * @return the name
   	 */
    @Column(name = "nombre")
    public String getName() {
        return name;
    }

    /**
	 * @param name the name to set
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * @return the iddocument
	 */
	public Long getIddocument() {
		return iddocument;
	}

	/**
	 * @param iddocument the iddocument to set
	 */
	public void setIddocument(Long iddocument) {
		this.iddocument = iddocument;
	}

	/**
	 * Compose the path to file
	 * @return path to file
	 */
	@Transient
    public String getUri() {
        return Labels.getLabel("parametro.adjuntos.folder") + getFileName();
    }

	/**
	 * Compose the file name
	 * @return file name
	 */
    @Transient
    public String getFileName() {
        return iddocument + "." + format;
    }
}
