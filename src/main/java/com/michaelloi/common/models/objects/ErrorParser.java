package com.michaelloi.common.models.objects;

import com.michaelloi.common.constants.FormatValues;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorParser {
    public static String getStackTrace(final Throwable throwable){
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

    public static JSONObject convertToJson(Throwable throwable){
        JSONObject responseBody = new JSONObject();
        JSONObject errorTag = new JSONObject();
        responseBody.put("error", errorTag);

        JSONArray detailList = new JSONArray();
        errorTag.put("details", detailList);

        Throwable nextRunner = throwable;
        while(nextRunner != null){
            Throwable runner = nextRunner;
            nextRunner = runner.getCause();

            JSONObject detailObj = new JSONObject();
            detailObj.put("code", runner.getClass().getName());
            detailObj.put("message", runner.toString());
            detailList.put(detailObj);
        }

        JSONArray stacklist = new JSONArray();
        if(throwable!=null){
            for(StackTraceElement stackTraceElement : throwable.getStackTrace()){
                stacklist.put(
                  String.format(
                      FormatValues.exception,
                      stackTraceElement.getFileName(),
                      stackTraceElement.getMethodName(),
                      stackTraceElement.getLineNumber()
                  )
                );
            }
        }

        errorTag.put("stack", stacklist);

        return responseBody;
    }
}
