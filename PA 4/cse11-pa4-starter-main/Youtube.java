import tester.*;

interface Comment{
    public boolean isCommentByAuthor(User author);
    public int totalLikes();
    public String unrollCommentThread();
}

class User{
    String username;
    String displayName;
//Constructor ----------------------------------------------
User(String username, String displayName){
    this.username = username;
    this.displayName = displayName;
}
}

class VideoComment implements Comment{
    String text;
    int likes;
    int replies;
    User author;
//Constructor ------------------------------------------------
VideoComment(String text, int likes, int replies, User author){
    this.text = text;
    this.likes = likes;
    this.replies = replies;
    this.author = author;
}
//Methods -------------------------------------------------
    public boolean isCommentByAuthor(User author){
        return this.author.username.equals(author.username);
    }

    public int totalLikes(){
        return this.likes;
    }

    public String unrollCommentThread(){
        return author.username + "\n" +
        this.likes + " likes" + "; " + this.replies + " replies" + "\n" +
        this.text;
    }

    public int totalInteractions(){
        return this.replies + this.likes;
    }
}

class ReplyComment implements Comment{
    String text;
    int likes;
    User author;
    Comment replyTo;
//Constructor -------------------------------------------------
ReplyComment(String text, int likes, User author, Comment replyTo){
    this.text = text;
    this.likes = likes;
    this.author = author;
    this.replyTo = replyTo;
}
//Methods --------------------------------------------------------
public boolean isCommentByAuthor(User author){
    return this.author.equals(author) && 
    this.replyTo.isCommentByAuthor(author);
}
public int totalLikes(){
    return this.likes + this.replyTo.totalLikes();
}
public String unrollCommentThread(){
    return replyTo + "\n" + 
    this.author.username + "\n" + 
    this.likes + " likes" + "\n" + 
    this.text;
}
}

class Youtube{
    User u1 = new User("test_username1", "Test User Full Name 1");
    User u2 = new User("test_username2", "Test User Full Name 2");

    Comment vc = new VideoComment("This is a great example to use the Tester Library!", 10, 5, u1);
    Comment rc1 = new ReplyComment("Yeah, I agree!", 7, u2, vc);
    Comment rc2 = new ReplyComment("Thanks for acknowledgment!", 4, u1, rc1);

    String rcans0 = vc.unrollCommentThread();
    String rcans1 = rc1.unrollCommentThread();
    String rcans2 = rc2.unrollCommentThread();
}