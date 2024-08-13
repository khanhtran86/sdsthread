package BTTongHop;

import java.util.List;

public class PhoneExtractor extends ContentExtractor{
    private static PhoneExtractor instance;
    public static PhoneExtractor getInstance()
    {
        if(instance==null)
            instance = new PhoneExtractor();
        return instance;
    }
    public List<String> getPhone(String content) {
        String phonePattern = "0[0-9]{9}";
        return super.getContents(phonePattern, content);
    }
}
