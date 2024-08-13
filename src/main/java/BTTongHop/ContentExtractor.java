package BTTongHop;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentExtractor {
    public List<String> getContents(String pattern, String content)
    {
        List<String> lstMatchedContent = new ArrayList<>();
        Pattern regPattern = Pattern.compile(pattern);

        Matcher matcher = regPattern.matcher(content);

        while (matcher.find())
        {
            lstMatchedContent.add(matcher.group());
        }

        return lstMatchedContent;
    }
}
