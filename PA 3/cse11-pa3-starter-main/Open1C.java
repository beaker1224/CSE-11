class method{

    static int sum(int int1, int int2){
        return int1 + int2;
    }
    static int times(int int1, int int2){
        return int1 * int2;
    }

}
class Open1C{
    int ex1 = method.sum(1,5);//expected: 6
    int ex2 = method.times(10,20);//expected: 200
}