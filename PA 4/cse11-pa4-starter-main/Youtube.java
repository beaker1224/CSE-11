import tester.*;

interface Comment{
    public boolean isCommentByAuthor(User author);
    public int totalLikes();
    public String unrollCommentThread();
    public int totalInteractions();
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
        this.text + "\n";
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
    return replyTo.unrollCommentThread() + 
    this.author.username + "\n" + 
    this.likes + " likes" + "\n" + 
    this.text + "\n";
}
public int totalInteractions(){
    return this.likes;
}
}

class Youtube{
    User u1 = new User("test_username1", "Test User Full Name 1");
    User u2 = new User("test_username2", "Test User Full Name 2");
    User u3 = new User("test_username3", "Test User Full Name 3");


    Comment vc = new VideoComment("This is a great example to use the Tester Library!", 10, 5, u1);
    Comment vc1 = new VideoComment("You know that it is not a good example right?", 200, 180, u3);

    Comment rc1 = new ReplyComment("Yeah, I agree!", 7, u2, vc);
    Comment rc2 = new ReplyComment("Thanks for acknowledgment!", 4, u1, rc1);
    Comment rc3 = new ReplyComment("I am the author", 0, u1, vc);
    Comment rc4 = new ReplyComment("once again, I am the author", 0, u1, rc3);

    String vcans0 = vc.unrollCommentThread();
    String rcans1 = rc1.unrollCommentThread();
    String rcans2 = rc2.unrollCommentThread();

    void testTotalLikes(Tester t){
        //totalLikes(); in VideoComments
        t.checkExpect(this.vc.totalLikes(), 10);
        t.checkExpect(this.vc1.totalLikes(), 200);
        //isCommentByAuthor(User author) in VideoComments
        t.checkExpect(this.vc.isCommentByAuthor(u1), true);
        t.checkExpect(this.vc1.isCommentByAuthor(u1), false);
        //unrollCommentThread(); in VideoComment
        t.checkExpect(this.vc.unrollCommentThread(), u1.username + "\n" +
        10 + " likes" + "; " + 5 + " replies" + "\n" +
        "This is a great example to use the Tester Library!" + "\n");
        t.checkExpect(this.vc1.unrollCommentThread(), u3.username + "\n" +
        200 + " likes" + "; " + 180 + " replies" + "\n" +
        "You know that it is not a good example right?" + "\n");
        //totalInteractions() in VideoComment
        t.checkExpect(this.vc.totalInteractions(), 15);
        t.checkExpect(this.vc1.totalInteractions(), 380);
        //totalLikes(); in ReplyComment
        t.checkExpect(this.rc1.totalLikes(), 17);
        t.checkExpect(this.rc2.totalLikes(), 21);
        //isCommentByAuthor(User author) in ReplyComment
        t.checkExpect(this.rc1.isCommentByAuthor(u1), false);
        t.checkExpect(this.rc2.isCommentByAuthor(u1), false);
        t.checkExpect(this.rc3.isCommentByAuthor(u1), true);
        t.checkExpect(this.rc4.isCommentByAuthor(u1), true);
        //unrollCommentThread(); in ReplyComment
        t.checkExpect(this.rc1.unrollCommentThread(), u1.username + "\n" +
        10 + " likes" + "; " + 5 + " replies" + "\n" +
        "This is a great example to use the Tester Library!" + "\n" + u2.username + "\n" + 
        7 + " likes" + "\n" + 
        "Yeah, I agree!" + "\n");
        t.checkExpect(this.rc2.unrollCommentThread(), u1.username + "\n" +
        10 + " likes" + "; " + 5 + " replies" + "\n" +
        "This is a great example to use the Tester Library!" + "\n" + u1.username + "\n" + 
        4 + " likes" + "\n" + 
        "Thanks for acknowledgment!" + "\n");
    }
}
