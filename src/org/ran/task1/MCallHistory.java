package org.ran.task1;

import java.sql.ResultSet;
import java.util.Properties;

@org.adempiere.base.Model(table="RCall_History")
public class MCallHistory extends X_RCall_History {

    private static final long serialVersionUID = -5036460035844762916L;

    public MCallHistory(Properties ctx, int RCall_History_ID, String trxName) {
        super(ctx, RCall_History_ID, trxName);
        System.out.println("=== MCALLHISTORY CONSTRUCTOR CALLED ===");
    }

    public MCallHistory(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
        System.out.println("=== MCALLHISTORY CONSTRUCTOR CALLED RS ===");
    }

    @Override
    protected boolean beforeSave(boolean newRecord) {
        System.out.println("=== MCALLHISTORY BEFORESAVE CALLED ===");
        System.out.println("=== BP ID: " + getC_BPartner_ID());
        System.out.println("=== SALESREP ID: " + getSalesRep_ID());

        if (newRecord) {

            // auto-select sales rep linked to this BP
            if (getSalesRep_ID() == 0 && getC_BPartner_ID() > 0) {
                int linkedSalesRepId = org.compiere.util.DB.getSQLValue(
                    get_TrxName(),
                    "SELECT SalesRep_ID FROM C_BPartner WHERE C_BPartner_ID = ?",
                    getC_BPartner_ID()
                );
                System.out.println("=== LINKED SALESREP ID: " + linkedSalesRepId);
                if (linkedSalesRepId > 0) {
                    System.out.println("=== AUTO SETTING SALESREP ===");
                    setSalesRep_ID(linkedSalesRepId);
                }
            }

            // auto-populate BP default phone
            if ((getPhone() == null || getPhone().isEmpty()) && getC_BPartner_ID() > 0) {
                MPhoneBook bpPhone = MPhoneBook.getDefaultForBPartner(
                    getCtx(), getC_BPartner_ID(), get_TrxName()
                );
                if (bpPhone != null) {
                    System.out.println("=== FOUND BP PHONE: " + bpPhone.getPhone());
                    setPhone(bpPhone.getPhone());
                } else {
                    System.out.println("=== NO BP PHONE FOUND");
                }
            }

            // auto-populate sales rep default phone
            if ((getPhone2() == null || getPhone2().isEmpty()) && getSalesRep_ID() > 0) {
                int salesRepBPId = org.compiere.util.DB.getSQLValue(
                    get_TrxName(),
                    "SELECT C_BPartner_ID FROM AD_User WHERE AD_User_ID = ?",
                    getSalesRep_ID()
                );
                System.out.println("=== SALESREP BP ID: " + salesRepBPId);

                if (salesRepBPId > 0) {
                    MPhoneBook repPhone = MPhoneBook.getDefaultForBPartner(
                        getCtx(), salesRepBPId, get_TrxName()
                    );
                    if (repPhone != null) {
                        System.out.println("=== FOUND REP PHONE: " + repPhone.getPhone());
                        setPhone2(repPhone.getPhone());
                    } else {
                        System.out.println("=== NO REP PHONE FOUND IN PHONEBOOK");
                    }
                } else {
                    System.out.println("=== NO BP LINKED TO THIS SALESREP USER");
                }
            }
        }

        return true;
    }
}