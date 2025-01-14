package com.robb.personalblog.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HomeService {
    public List<String> getTitleDate(String json) {
        List<String> info = new ArrayList<>();
        String regex = "\"title\"\s*:\s*\"([^\"]+)\"|date\"\s*:\s*\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                info.add(matcher.group(1));
            }
            if (matcher.group(2) != null) {
                info.add(matcher.group(2));
            }
        }
        return info;
    }
}
