package com.hnair.pay.common;

import com.hnair.pay.common.utils.IDUtil;
import com.hnair.pay.common.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

/**
 * IntelliJ IDEA
 *
 * @author: hanyk
 * @date: 18/4/25
 * @time 19-25
 */
@Service
public class OrderSequeneService {

    private final Logger logger = LoggerFactory.getLogger("OrderSequeneService");

    @Resource
    DataSource  dataSourceRw;

    private static byte m_appID = 0x00;

    // maximum lo count
    private static int MAX_LO = 0xFFFF;

    private int m_lo;

    private int m_hi;

    private static HashMap<String, String> generatorTable = new HashMap<String, String>();

    /**
     * 获取seqId
     * @return
     */
    public synchronized String querySeqId() {
        long subId = getLongId();
        String dayPrefix = TimeUtil.format_yyyyMMddHH(new Date());
//        String sequencePrefix = "00000" + (subId % 100000);
//        sequencePrefix = sequencePrefix.substring(sequencePrefix.length() - 5);
        return dayPrefix + subId;
    }

    public OrderSequeneService() {
        m_lo = (short) 0;
    }

    private long getLongId() {
        getNextLo();
        long id = IDUtil.getID(m_hi, m_lo, m_appID, (byte) 0);
        return id;
    }

    private int getNextLo() {
        if (!generatorTable.containsKey("order_sequene")) {
            generatorTable.put("order_sequene", "order_sequene");
            m_hi = queryDataSeqId();
        }
        if (MAX_LO == m_lo) {
            m_hi = queryDataSeqId();
            m_lo = 0;
        } else {
            m_lo++;
        }
        return m_lo;
    }

    private int queryDataSeqId(){
        final String DEFAULT_SEQ_TABLE = "pay_order_sequence";
        int seq = 3000;
        try {
            seq = querySeqId(DEFAULT_SEQ_TABLE);
        }catch (Exception e){
            logger.error("获取主键id异常", e);
        }
        return  seq;
    }

    public int querySeqId(String tableName){
        int seq = 3000;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            con = dataSourceRw.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("REPLACE INTO "+ tableName + "(stub) VALUES('a')");
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            while(rs.next()){
                seq = rs.getInt(1);
            }
        }catch(Exception e){
            logger.error("getSeqId failure",e);
        } finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try{
                    stmt.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(con != null){
                try{
                    con.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return seq;
    }
}
