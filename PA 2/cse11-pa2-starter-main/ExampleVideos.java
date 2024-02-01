class User{
    // Define variable names----------------------------------------------------------
    String userName;
    String displayName;
    int numberOfSubscribers;
    int numberOfVideos;

    // Define constructors----------------------------------------------------------
    User (String userName, String displayName, int numberOfSubscribers, int numberOfVideos){
        this.userName = userName;
        this.displayName = displayName;
        this.numberOfSubscribers = numberOfSubscribers;
        this.numberOfVideos = numberOfVideos;
    }

    // Define methods----------------------------------------------------------
    String toText(){
        return this.displayName + " @" + this.userName;
    }

}


class Video{
    // Define variable names----------------------------------------------------------
    String title;
    User User;
    int countOfLikes;
    String videoID;

    // Define constructors----------------------------------------------------------
    Video (String title, User User, int countOfLikes, String videoID){
        this.title = title;
        this.User = User;
        this.countOfLikes = countOfLikes;
        this.videoID = videoID;
    }

    // Define methods----------------------------------------------------------
    boolean longerThan(Video other){
        if(this.title.length() > other.title.length()){
            return true;
        }else{return false;}
    }

    boolean moreLikes(Video other){
        if(this.countOfLikes > other.countOfLikes){
            return true;
        }
        else{return false;}
    }

    String toText(){
        return User.displayName + " @" + User.userName + " : " +
                this.title + " : " + this.countOfLikes + " Likes";
    }

    String toLink(){
        return "https://www.youtube.com/watch?v=" + this.videoID;
    }

}


class ExampleVideos{
    // construction of Users----------------------------------------------------------
    User Jacob = new User("JacobsSchoolNews", "JacobsSchoolNews", 3250, 444);
    User Tech = new User("techroastshow", "Tech Roast Show", 9280, 603);
    User Fireship = new User("Fireship", "Fireship", 2750000, 601);
   
    // construction of Videos----------------------------------------------------------
    //“Were there any parts of the Video that you couldn’t represent with the class design we chose?”
    //https://www.youtube.com/watch?v=UBUtxfUY_w0
    //we cannot see how many people have watched it, the length of the video, and how long has this video been on Youtube
    Video Jacobv1 = new Video("Robot Learns to Smile at UC San Diego", Jacob, 118, "UBUtxfUY_w0");
    //https://www.youtube.com/watch?v=FaPVXddg6mE
    //we cannot see how many people have watched it, the length of the video, and how long has this video been on Youtube
    Video Jacobv2 = new Video("Transforming Clinical Recording of Deep Brain Activity with a New Take on Sensor Manufacturing", Jacob, 17, "FaPVXddg6mE");
    //https://www.youtube.com/watch?v=sHZ9nXbzEtQ
    //we cannot see how many people have watched it, the length of the video, and how long has this video been on Youtube
    Video Techv = new Video("Comedians Roast Tech Bro Who Raps in Mandarin", Tech, 34, "sHZ9nXbzEtQ");
    //https://www.youtube.com/watch?v=eHzoTLwx01E
    //we cannot see how many people have watched it, the length of the video, and how long has this video been on Youtube
    Video Fireshipv = new Video("CES 2024… a glimpse into our AI-powered future", Fireship, 32000, "eHzoTLwx01E");

    //testing on class:User -------------------------------------------------
    String u1name = Jacob.toText();//should: JacobsSchoolNews @JacobsSchoolNews
    String u2name = Tech.toText();//should: Tech Roast Show @techroastshow
    //testing on class:Video -------------------------------------------------
    boolean test_1_1 = Jacobv1.longerThan(Jacobv2);//should: false
    boolean test_1_2 = Jacobv2.longerThan(Jacobv1);//should: true
    boolean test_1_3 = Techv.longerThan(Fireshipv);//should: false
    boolean test_2_1 = Jacobv1.moreLikes(Jacobv2);//should: true
    boolean test_2_2 = Fireshipv.moreLikes(Techv);//should: true
    boolean test_2_3 = Jacobv2.moreLikes(Techv);//should: false
    String v1name = Jacobv1.toText();//should: "JacobsSchoolNews @JacobsSchoolNews : Robot Learns to Smile at UC San Diego : 118 Likes"
    String v2name = Techv.toText();//should: "Tech Roast Show @techroastshow : Comedians Roast Tech Bro Who Raps in Mandarin : 34 Likes"
    String v1link = Jacobv1.toLink();//should: "https://www.youtube.com/watch?v=UBUtxfUY_w0"
    String v2link = Jacobv2.toLink();//should: "https://www.youtube.com/watch?v=FaPVXddg6mE"
}