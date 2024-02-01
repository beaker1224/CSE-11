import tester.*;

class User{
    String Username;
    String displayName;

    interface Comment{
        public boolean isCommentByAuthor(User author);
        public int totalLikes();
        public String unrollCommentThread();
    }

}

class VideoComment implements Comment{
    String text;
    int likes;
    int replies;
    User author;

VideoComment(String text, int likes, int replies, User author){
    this.text = text;
    this.likes = likes;
    this.replies = replies;
    this.author = author;
}
}