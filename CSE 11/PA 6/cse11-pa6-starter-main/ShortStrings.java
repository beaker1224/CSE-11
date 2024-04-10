import tester.Tester;

class ShortStrings{
    String[] shortStrings(String[] input, int n){
        int length = 0;
        for(String s: input){
            if(s.length() <= n){
                length ++;
            }
        }
        String[] output = new String[length];
        int position = 0;
        for(String s: input){
            if(s.length() <= n){
                output[position] = s;
                position ++;
            }
        }
        return output;
    }
//test shortStrings
    void testshortStrings(Tester t){
        String[] s1 = {"banana", "is", "the", "best"};//4
        String[] e1 = {"is", "the", "best"}; 
        String[] s2 = {"I", "love", "banana", "and", "orange"};//5
        String[] e2 = {"I", "love", "and"};
        String[] s3 = {"everything", "in", "this", "array", "will", "be", "shown"};//10
        String[] e3 = {"everything", "in", "this", "array", "will", "be", "shown"};
        String[] s4 = {"nothing", "will", "show"};//0
        String[] e4 = {};
        t.checkExpect(shortStrings(s1, 4), e1);
        t.checkExpect(shortStrings(s2, 5), e2);
        t.checkExpect(shortStrings(s3, 10), e3);
        t.checkExpect(shortStrings(s4, 0), e4);
    }
}