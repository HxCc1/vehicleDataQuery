package org.xgqc.util.canParseUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CanParserFactory {
    private final Map<String, CanDataParser> parserMap = new HashMap();
    private final List<CanDataParser> parsers;

    public CanParserFactory(List<CanDataParser> parsers) {
        this.parsers = parsers;
    }

    @PostConstruct
    public void init() {
        this.parsers.forEach((parser) -> {
            String canId = parser.getSupportedCanId();
            if (this.parserMap.containsKey(canId)) {
                throw new IllegalStateException("Duplicate CAN ID: " + canId);
            } else {
                this.parserMap.put(canId, parser);
            }
        });
    }

    public CanDataParser getParser(String canId) {
        return (CanDataParser)this.parserMap.get(canId);
    }
}

