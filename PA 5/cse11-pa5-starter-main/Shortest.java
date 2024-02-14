class Shortest {
    public static void main(String[] args){
        if(args.length > 0){
            int position = 0;
            for(int i = 0; i < args.length - 1; i++){
                if(args[position].length() > args[i + 1].length()){
                    position = i + 1;
                }
            }
            System.out.println(args[position]);
        }
        System.out.println("");
    }
}
