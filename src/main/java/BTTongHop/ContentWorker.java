package BTTongHop;

import java.util.List;
import java.util.Queue;

public class ContentWorker implements Runnable{
    Queue<String> queue;
    public ContentWorker(Queue<String> store)
    {
        this.queue =store;
    }
    @Override
    public void run() {
        while (true)
        {
            if(queue.size()>0)
            {
                String content = queue.poll();
                EmailExtractor emailExtractor = EmailExtractor.getInstance();
                List<String> emails = emailExtractor.getEmails(content);
                emails.forEach(System.out::println);
            }
        }
    }
}
