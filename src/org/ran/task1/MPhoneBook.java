package org.ran.task1;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

@org.adempiere.base.Model(table="Rphone_Book")
public class MPhoneBook extends X_Rphone_Book {

    private static final long serialVersionUID = 2179999344333560441L;

    public MPhoneBook(Properties ctx, int Rphone_Book_ID, String trxName) {
        super(ctx, Rphone_Book_ID, trxName);
        System.out.println("=== MPHONEBOOK CONSTRUCTOR CALLED ===");
    }

    public MPhoneBook(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
        System.out.println("=== MPHONEBOOK CONSTRUCTOR CALLED RS ===");
    }

    public static MPhoneBook getDefaultForBPartner(Properties ctx, int bPartnerId, String trxName) {
        return new org.compiere.model.Query(ctx, Table_Name,
                "C_BPartner_ID = ? AND IsDefault = 'Y'", trxName)
                .setParameters(bPartnerId)
                .first();
    }

    @Override
    protected boolean beforeSave(boolean newRecord) {
        System.out.println("=== MPHONEBOOK BEFORESAVE CALLED ===");

        // If this is the first phone for this BP, auto set as default
        if (newRecord) {
            int existingCount = org.compiere.util.DB.getSQLValue(
                get_TrxName(),
                "SELECT COUNT(*) FROM " + Table_Name + " WHERE C_BPartner_ID = ?",
                getC_BPartner_ID()
            );
            System.out.println("=== EXISTING PHONES COUNT: " + existingCount);
            if (existingCount == 0) {
                System.out.println("=== FIRST PHONE FOR THIS BP, AUTO SETTING AS DEFAULT ===");
                setIsDefault(true);
            }
        }

        // If marked as default, clear all other defaults for same BP
        if (isDefault()) {
            System.out.println("=== CLEARING OTHER DEFAULTS ===");
            org.compiere.util.DB.executeUpdateEx(
                "UPDATE " + Table_Name +
                " SET IsDefault = 'N'" +
                " WHERE C_BPartner_ID = ?" +
                " AND " + Table_Name + "_ID != ?",
                new Object[]{ getC_BPartner_ID(), get_ID() },
                get_TrxName()
            );
        }
        return true;
    }
}