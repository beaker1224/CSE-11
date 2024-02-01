class R{
    String content;
    R comment;
//constructor---------------------------
    R(String content, R replyTo){
        this.content = content;
        this.comment = replyTo;
    }
}

class ExamplesR{
    R ex1 = new R("nice", null);
    R ex2 = new R("yes it is nice", ex1);
    R ex3 = new R("I don't think so", ex2);
    String theFirstComment = ex3.comment.comment.content;
}
//Answer to Question 1
/*I am able to construct an example R object, my first example
is "ex1", which the second field in the constructor is null,
since I don't known what should I put there yet. Then "ex2" is like
a second person commenting on the first person called "ex2", then the 
second field I can put "ex1" since it is a R object. The null in the
first R object means this is the first one, and I have nothing to refer.
"theFirstComment" is an explainition of how I can get the first person's comment
from the third person "ex3"
*/

//Answer to Question 2
class VideoComment{
    String text;
    int likes;
    int replies;
    VideoComment(String text, int likes, int replies){
        this.text = text;
        this.likes = likes;
        this.replies = replies;
    }
}

class CommentReply{
    VideoComment replyTo;
    String text;
    int likes;
    int replies;
    CommentReply(VideoComment replyTo, String text, int likes, int replies){
        this.replyTo = replyTo;
        this.text = text;
        this.likes = likes;
        this.replies = replies;
    }
}

class Examples2{
    CommentReply p1 = new CommentReply(null, "this sounds great", 0, 0);
    CommentReply p2 = new CommentReply(p1.replyTo, "then should we go tomorrow?", 0, 0);
    /*
     * here we cannot construct an example of a reply to a reply
     * to a Comment, because we now requires a vidoComment object in one
     * of the CommentReply object's field but in the example I provided above,
     * "p1" itself will be too much for the VideoComment portion of CommentReply
     * from "p2", thus the only solution is to use "p1.replyTo" because it is a
     * VideoComment object. In this case, all the new CommentReply will be pointed 
     * towards the VideoComment itself, instead of point to the reply (or replies)
     * of the VideoComment
     */
}

