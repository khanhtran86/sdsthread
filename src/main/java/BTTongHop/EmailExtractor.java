package BTTongHop;

import java.util.List;

public class EmailExtractor extends ContentExtractor{
    private static EmailExtractor instance;
    public static EmailExtractor getInstance()
    {
        if(instance==null)
            instance = new EmailExtractor();
        return instance;
    }

    public List<String> getEmails(String content) {
        String pattern = "[a-zA-Z0-9\\._]+@\\w+.\\w{2,3}.\\w{2,3}";
        return super.getContents(pattern, content);
    }
}
