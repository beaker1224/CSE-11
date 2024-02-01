class Drill4{
//Methods-----------------------------------------------
    String phaseOfWater(int number){
        if(number >= 100){return "vapor";}
        if(number < 100 && number > 0){return "liquid";}
        else{return "solid";}
    }
    int maxProduct(int n1, int n2, int n3){
        int ans1 = n1 * n2;
        int ans2 = n1 * n3;
        int ans3 = n2 * n3;
        if(ans1 > ans2 && ans1 > ans3){return ans1;}
        if(ans2 > ans1 && ans2 > ans3){return ans2;}
        else{return ans3;}
    }
    double pipeVolume(double innerR, double outerR, double height){
        return Math.PI * height * (Math.pow(outerR,2) - Math.pow(innerR, 2));
    }



    String phase1 = phaseOfWater(70);//expected: liquid
    String phase2 = phaseOfWater(-20);//expected: solid
    String phase3 = phaseOfWater(0);//expected: solid
    String phase4 = phaseOfWater(100);//expected: vapor
    int max1 = maxProduct(1,2,3);//expected: 6
    int max2 = maxProduct(2,5,10);//expected: 50
    int max3 = maxProduct(-4,1,30);//expected: 30
    double volume1 = pipeVolume(1, 2, 0);//expected: 0.0
    double volume2 = pipeVolume(1, 3, 1);//expected: 25.1327
    double volume3 = pipeVolume(5, 7, 10);//expected: 753.982
}