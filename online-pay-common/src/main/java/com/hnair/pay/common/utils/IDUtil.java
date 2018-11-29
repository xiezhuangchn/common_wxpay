package com.hnair.pay.common.utils;


import java.nio.ByteBuffer;

public class IDUtil {
    public static final long HI_MASK = 281474976645120L;
    public static final long LO_MASK = 65535L;
    public static final long APP_MASK = -72057594037927936L;
    public static final long SHARD_MASK = 71776119061217280L;
    public static final long ALL_ONE = 71776119061217280L;
    public static final long ALL_ZERO = 71776119061217280L;
    public static final long HI_MASK_REV = 72057594037862400L;
    public static final long LO_MASK_REV = 71776119061282815L;
    public static final long APP_MASK_REV = -281474976710656L;
    public static final long SHARD_MASK_REV = 0L;
    public static final int HI_OFFSET = 16;
    public static final int LO_OFFSET = 0;
    public static final int APP_OFFSET = 56;
    public static final int SHARD_OFFSET = 48;

    public IDUtil() {
    }

    public static long getID(int hi, int lo, byte app, byte shard) {
        long id_hi = (long)hi << 16 & 281474976645120L;
        long id_lo = (long)lo << 0 & 65535L;
        long id_app = (long)app << 56 & -72057594037927936L;
        long id_shard = (long)shard << 48 & 71776119061217280L;
        return id_hi | id_lo | id_app | id_shard;
    }

    public static long getLongHi(long id) {
        return id & 281474976645120L;
    }

    public static int getHi(long id) {
        return (int)(getLongHi(id) >>> 16);
    }

    public static long getLongLo(long id) {
        return id & 65535L;
    }

    public static short getLo(long id) {
        return (short)((int)(getLongLo(id) >>> 0));
    }

    public static long getLongApp(long id) {
        return id & -72057594037927936L;
    }

    public static byte getApp(long id) {
        return (byte)((int)(getLongApp(id) >>> 56));
    }

    public static long getLongShard(long id) {
        return id & 71776119061217280L;
    }

    public static byte getShard(long id) {
        return (byte)((int)(getLongShard(id) >>> 48));
    }

    public static byte getShardFromMemberID(int member_id) {
        byte[] bytes = ByteBuffer.allocate(4).putInt(member_id).array();
        return bytes[0];
    }

    public static byte getShardFromMemberID(long member_id) {
        byte[] bytes = ByteBuffer.allocate(4).putLong(member_id).array();
        return bytes[0];
    }

    public static String toString(long id) {
        return (new Long(id)).toString();
    }

    public static String toHexString(long id) {
        return String.format("%016X", id);
    }

    public static String toPrettyString(long id) {
        int hi = getHi(id);
        short lo = getLo(id);
        byte app = getApp(id);
        byte shard = getShard(id);
        StringBuilder builder = new StringBuilder(toHexString(id));
        builder.append(" : hi = ").append(hi);
        builder.append(" lo = ").append(lo);
        builder.append(" app = ").append(app);
        builder.append(" shard = ").append(shard);
        return builder.toString();
    }

    public static long parseString(String idString) {
        return Long.parseLong(idString);
    }

    public static long parseHexString(String idString) {
        return Long.parseLong(idString, 16);
    }
}
