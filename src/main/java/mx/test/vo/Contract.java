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
import java.util.Date;
import javax.persistence.*;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.util.Base;
/**
 * Contract persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_contract")
public class Contract extends Base{
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5934463000231137180L;
	/**
	 * contract id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",  nullable = false)
	private Integer id;
	/**
	 * regestry date
	 */
	@Temporal(TemporalType.DATE)
	private Date registryDate;
	/**
	 * contract type
	 * DRField makes searchable by this attribute
	 */
	@DRField(actions= FormActions.SEARCH, searchOperador=DRField.Operator.EQUALS,label=@DRLabel(key=DRLabel.NO_LABEL))
	private String type;
	/**
	 * contract content
	 */
	private String content;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the registryDate
	 */
	public Date getRegistryDate() {
		return registryDate;
	}
	/**
	 * @param registryDate the registryDate to set
	 */
	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
