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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import mx.dr.util.Base;

/**
 * Document persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_document")
public class Document extends Base{
	/**
	 * serial
	 */
	private static final long serialVersionUID = -6553504613095469383L;
	/**
	 * Document id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
	/**
	 * document data content
	 */
    @Column(name="data_content")
    @Lob
    private byte[] dataContent;
	/**
	 * @return the id
	 */
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
	 * @return the dataContent
	 */
	public byte[] getDataContent() {
		return dataContent;
	}
	/**
	 * @param dataContent the dataContent to set
	 */
	public void setDataContent(byte[] dataContent) {
		this.dataContent = dataContent;
	}


}
