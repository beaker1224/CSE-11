class Stats {
    public static void main(String[] args) {
        if(args[0].substring(0,2).compareTo("--") == 0){
            if(args[0].substring(2).compareTo("product") == 0){
                double product = 1;
                for(int i = 1; i < args.length; i++){
                    product = product * Double.parseDouble(args[i]);
                }
                System.out.println(product);
            }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if(args[0].substring(2).compareTo("mean") == 0){
                double sum = 0;
                for(int i = 1; i < args.length; i++){
                    sum += Double.parseDouble(args[i]);
                }
                System.out.println(sum / (args.length - 1));               
            }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if(args[0].substring(2).compareTo("total") == 0){
                double total = 0;
                for(int i = 1; i < args.length; i++){
                    total += Double.parseDouble(args[i]);
                }
                System.out.println(total);                
            }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if(args[0].substring(2).compareTo("max") == 0){
                int position = 1;
                for(int i = 1; i < args.length; i++){
                    if(Double.parseDouble(args[position]) < Double.parseDouble(args[i])){
                        position = i;
                    }
                }
                System.out.println(Double.parseDouble(args[position]));                
            }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if(args[0].substring(2).compareTo("min") == 0){
                int position = 1;
                for(int i = 1; i < args.length; i++){
                    if(Double.parseDouble(args[position]) > Double.parseDouble(args[i])){
                        position = i;
                    }
                }
                System.out.println(Double.parseDouble(args[position]));                
            }
            System.out.println("Bad option " + args[0]);
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        }else{
            System.out.println("Bad option " + args[0]);
        }
    }
}
