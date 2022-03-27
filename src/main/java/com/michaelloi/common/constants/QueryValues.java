package com.michaelloi.common.constants;

public class QueryValues {
    public static final String getSessionId =
        "SELECT sessionid, username " +
        "FROM public.tbl_user " +
        "WHERE sessionid = :sessionid "+
        "AND isactive = true";
}
