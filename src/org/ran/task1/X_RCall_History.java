/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.ran.task1;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for RCall_History
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="RCall_History")
public class X_RCall_History extends PO implements I_RCall_History, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20260331L;

    /** Standard Constructor */
    public X_RCall_History (Properties ctx, int RCall_History_ID, String trxName)
    {
      super (ctx, RCall_History_ID, trxName);
      /** if (RCall_History_ID == 0)
        {
			setC_BPartner_ID (0);
			setName (null);
			setRCall_History_ID (0);
			setSalesRep_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RCall_History (Properties ctx, int RCall_History_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, RCall_History_ID, trxName, virtualColumns);
      /** if (RCall_History_ID == 0)
        {
			setC_BPartner_ID (0);
			setName (null);
			setRCall_History_ID (0);
			setSalesRep_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RCall_History (Properties ctx, String RCall_History_UU, String trxName)
    {
      super (ctx, RCall_History_UU, trxName);
      /** if (RCall_History_UU == null)
        {
			setC_BPartner_ID (0);
			setName (null);
			setRCall_History_ID (0);
			setSalesRep_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RCall_History (Properties ctx, String RCall_History_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, RCall_History_UU, trxName, virtualColumns);
      /** if (RCall_History_UU == null)
        {
			setC_BPartner_ID (0);
			setName (null);
			setRCall_History_ID (0);
			setSalesRep_ID (0);
        } */
    }

    /** Load Constructor */
    public X_RCall_History (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_RCall_History[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	@Deprecated(since="13") // use better methods with cache
	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Duration.
		@param Duration Normal Duration in Duration Unit
	*/
	public void setDuration (int Duration)
	{
		set_Value (COLUMNNAME_Duration, Integer.valueOf(Duration));
	}

	/** Get Duration.
		@return Normal Duration in Duration Unit
	  */
	public int getDuration()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Duration);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Comment/Help.
		@param Help Comment or Hint
	*/
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp()
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set BP_Phone.
		@param Phone Identifies a telephone number
	*/
	public void setPhone (String Phone)
	{
		set_ValueNoCheck (COLUMNNAME_Phone, Phone);
	}

	/** Get BP_Phone.
		@return Identifies a telephone number
	  */
	public String getPhone()
	{
		return (String)get_Value(COLUMNNAME_Phone);
	}

	/** Set User_Phone.
		@param Phone2 Identifies an alternate telephone number.
	*/
	public void setPhone2 (String Phone2)
	{
		set_Value (COLUMNNAME_Phone2, Phone2);
	}

	/** Get User_Phone.
		@return Identifies an alternate telephone number.
	  */
	public String getPhone2()
	{
		return (String)get_Value(COLUMNNAME_Phone2);
	}

	/** Set RCall History.
		@param RCall_History_ID RCall History
	*/
	public void setRCall_History_ID (int RCall_History_ID)
	{
		if (RCall_History_ID < 1)
			set_ValueNoCheck (COLUMNNAME_RCall_History_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_RCall_History_ID, Integer.valueOf(RCall_History_ID));
	}

	/** Get RCall History.
		@return RCall History	  */
	public int getRCall_History_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RCall_History_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set RCall_History_UU.
		@param RCall_History_UU RCall_History_UU
	*/
	public void setRCall_History_UU (String RCall_History_UU)
	{
		set_Value (COLUMNNAME_RCall_History_UU, RCall_History_UU);
	}

	/** Get RCall_History_UU.
		@return RCall_History_UU	  */
	public String getRCall_History_UU()
	{
		return (String)get_Value(COLUMNNAME_RCall_History_UU);
	}

	@Deprecated(since="13") // use better methods with cache
	public org.compiere.model.I_AD_User getSalesRep() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getSalesRep_ID(), get_TrxName());
	}

	/** Set Sales Representative.
		@param SalesRep_ID Sales Representative or Company Agent
	*/
	public void setSalesRep_ID (int SalesRep_ID)
	{
		if (SalesRep_ID < 1)
			set_ValueNoCheck (COLUMNNAME_SalesRep_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
	}

	/** Get Sales Representative.
		@return Sales Representative or Company Agent
	  */
	public int getSalesRep_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SalesRep_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}