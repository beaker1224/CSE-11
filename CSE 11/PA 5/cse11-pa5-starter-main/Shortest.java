class Shortest {
    public static void main(String[] args){
        if(args.length == 0){return;}

        int min = args[0].length();
        String ans = args[0];
        for(String s: args){
            if(s.length() < min){
                ans = s;
                min = s.length();
            }
        }

        System.out.println(ans);
    }




    
}
