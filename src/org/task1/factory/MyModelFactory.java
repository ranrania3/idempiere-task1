package org.task1.factory;

import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.ran.task1.MCallHistory;
import org.ran.task1.MPhoneBook;

public class MyModelFactory implements IModelFactory {

    private static final CLogger log = CLogger.getCLogger(MyModelFactory.class);

    @Override
    public Class<?> getClass(String tableName) {
        log.warning("=== FACTORY CALLED FOR: " + tableName + " ===");
        
        if (MPhoneBook.Table_Name.equals(tableName))
            return MPhoneBook.class;
        if (MCallHistory.Table_Name.equals(tableName))
            return MCallHistory.class;
        return null;
    }

    @Override
    public PO getPO(String tableName, int Record_ID, String trxName) {
        Properties ctx = Env.getCtx();
        if (MPhoneBook.Table_Name.equals(tableName))
            return new MPhoneBook(ctx, Record_ID, trxName);
        if (MCallHistory.Table_Name.equals(tableName))
            return new MCallHistory(ctx, Record_ID, trxName);
        return null;
    }

    @Override
    public PO getPO(String tableName, ResultSet rs, String trxName) {
        Properties ctx = Env.getCtx();
        if (MPhoneBook.Table_Name.equals(tableName))
            return new MPhoneBook(ctx, rs, trxName);
        if (MCallHistory.Table_Name.equals(tableName))
            return new MCallHistory(ctx, rs, trxName);
        return null;
    }
}