class PositiveMinMaxAvg {
    public static void main(String[] args){
        int length = 0;
        int position = 0;
        for(String s: args){
            if(Double.parseDouble(s) > 0){
                length ++;
            }
        }
        if(length < 2){
            System.out.println(0);
            return;
        }
        double[] positives = new double[length];
        //System.out.println(positives.length);
        for(int i = 0; i < args.length; i++){
            if(Double.parseDouble(args[i]) > 0){
                positives[position] = Double.parseDouble(args[i]);
                position ++;
            }
        }

        double min = positives[0];
        double max = 0;
        
        for(double s: positives){
            if(s < min){
                min = s;
            }
// max is done, to zero 
            if(s > max){
                max = s;
            }
        }
        System.out.println((min + max) / 2);
    }
}