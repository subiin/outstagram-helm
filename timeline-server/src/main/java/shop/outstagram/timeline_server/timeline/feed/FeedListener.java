package shop.outstagram.timeline_server.timeline.feed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class FeedListener {

    private final ObjectMapper objectMapper;
    private final FeedStore feedStore;

    public FeedListener(ObjectMapper objectMapper, FeedStore feedStore) {
        this.objectMapper = objectMapper;
        this.feedStore = feedStore;
    }

    @KafkaListener(topics = "feed.created", groupId = "timeline-server")
    public void listen(String message) {
        try {
            FeedInfo feed = objectMapper.readValue(message, FeedInfo.class);
            feedStore.savePost(feed);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
