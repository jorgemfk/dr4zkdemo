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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import mx.dr.util.Base;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "ml_registry_fiscal")
public class FiscalRegistry extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Integer id;

    @Column(name = "fiscal_name")
    private String fiscalName;
    private String rfc;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idaddress")
    private Address fiscalAddress;

    public Address getFiscalAddress() {
        return fiscalAddress;
    }

    public void setFiscalAddress(Address direccionFiscal) {
        this.fiscalAddress = direccionFiscal;
    }

    public String getFiscalName() {
        return fiscalName;
    }

    public void setFiscalName(String razonSocial) {
        this.fiscalName = razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


}
