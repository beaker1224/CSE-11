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
second field I can put "ex1" since it is a R object.
"theFirstComment" is an explainition of how I can get the first person's comment
from the third person "ex3"
*/
//Answer to Question 2
/*

 */
