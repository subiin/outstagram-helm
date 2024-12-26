package shop.outstagram.timeline_server.timeline;

public class LikeResponse {
    long likeCount;
    boolean like;

    public LikeResponse(long likeCount, boolean like) {
        this.likeCount = likeCount;
        this.like = like;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public boolean isLike() {
        return like;
    }
}
