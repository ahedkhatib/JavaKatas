package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NginxLogsParserTest {

    @Test
    void validLogTest(){
        String logEntry = "122.176.223.47 - - [05/Feb/2024:08:29:40 +0000] " +
                "\"GET /web-enabled/Enhanced-portal/bifurcated-forecast.js HTTP/1.1\" 200 1684 " +
                "\"-\" \"Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00\"";

        Map<String, String> parsedLog = NginxLogsParser.parseLog(logEntry);

        Map<String, String> expectedParsedData = NginxLogsParser.parseLog(logEntry);
        expectedParsedData.put("client_ip", "122.176.223.47");
        expectedParsedData.put("date", "05/Feb/2024:08:29:40 +0000");
        expectedParsedData.put("http_method", "GET");
        expectedParsedData.put("path", "/web-enabled/Enhanced-portal/bifurcated-forecast.js");
        expectedParsedData.put("http_version", "1.1");
        expectedParsedData.put("status", "200");
        expectedParsedData.put("response_bytes", "1684");
        expectedParsedData.put("user_agent", "Opera/9.58 (X11; Linux i686; en-US) Presto/2.12.344 Version/13.00");

        assertEquals(expectedParsedData, parsedLog);
    }

    @Test
    void inValidLogTest(){
        String inValid = " Invalid log format";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NginxLogsParser.parseLog(inValid);
        });

        assertEquals("Invalid log format", exception.getMessage());
    }
}
