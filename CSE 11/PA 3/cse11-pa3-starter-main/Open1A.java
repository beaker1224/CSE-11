class Open1AA{
    int likes;
    int replies;
    
Open1AA(int likes, int replies){
    this.likes = likes;
    this.replies = replies;
}
int sum(Open1AA second){
    return this.likes + second.replies;
}
}

class Open2AA{
    int likes;
    int replies;
Open2AA(int likes, int replies){
    this.likes = likes;
    this.replies = replies;
}
int sum(){
    return this.likes + this.replies;
}
}

class Open1A{
    Open1AA ex1 = new Open1AA(10, 20);
    Open1AA ex2 = new Open1AA(10, 80);
    Open2AA ex3 = new Open2AA(10, 20);
    Open2AA ex4 = new Open2AA(10, 20);
    int ans1 = ex1.sum(ex2);//expected: 90
    int ans2 = ex2.sum(ex2);//expected: 70
    int ans3 = ex3.sum();//30
    int ans4 = ex4.sum();//10
}