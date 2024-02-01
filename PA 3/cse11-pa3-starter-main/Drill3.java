class VideoComment{
    String text;
    int likes;
    int replies;
    VideoComment(String text, int likes, int replies){
        this.text = text;
        this.likes = likes;
        this.replies = replies;
    }

    boolean hasMention(String username){
        String target = "@" + username;
        if(this.text.contains(target + " ")){return true;}
        if(this.text.indexOf(target) == this.text.length() - target.length() && this.text.indexOf(target) > -1){return true;}
        return false;
    }

    boolean hasReply(){
        return this.replies > 0;
    }

    String firstMention(){
        int firstAt = this.text.indexOf("@");
        if(firstAt == -1){return "";}
        int firstSpace = this.text.indexOf(" ", firstAt);
        if(firstSpace == -1){return "";}
        return this.text.substring(firstAt + 1, firstSpace);
    }
}

class CommentReply{
    VideoComment replyTo;
    String text;
    int likes;
    int replies;
//Constructor------------------------------------------------------------------------
    CommentReply(VideoComment replyTo, String text, int likes, int replies){
        this.replyTo = replyTo;
        this.text = text;
        this.likes = likes;
        this.replies = replies;
    }
//Methods-----------------------------------------------------------------------------
    boolean morePopularReply(){
        return this.likes > this.replyTo.likes;
    }

    int allLikes(){
        return this.likes + this.replyTo.likes;
    }

    boolean hasMention(String username){
        String target = "@" + username;
        if(this.text.contains(target + " ") || this.replyTo.text.contains(target + " ")){return true;}
        if(this.text.indexOf(target) == this.text.length() - target.length() && this.text.indexOf(target) > -1
        || this.replyTo.text.indexOf(target) == this.replyTo.text.length() - target.length() && this.replyTo.text.indexOf(target) > -1){return true;}
        return false;
    }
}
