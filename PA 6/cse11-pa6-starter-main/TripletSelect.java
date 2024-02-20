import tester.*;
class TripletSelect {
    int a, b, c;
//Constructor
    TripletSelect() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
    TripletSelect(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

//Method getBs
    int[] getBs(TripletSelect[] triplets){
        int[] Bs = new int[triplets.length];
        for(int i = 0; i < triplets.length; i++){
            Bs[i] = triplets[i].b;
        }
        return Bs;
    }
//Test the method
    void testTripletSelect(Tester t){
        TripletSelect[] t1 = {new TripletSelect(1, 2, 3), new TripletSelect(1, 0, 3), 
                        new TripletSelect(1, 4, 3), new TripletSelect(1, 5, 3)}; //2 0 4 5
        TripletSelect[] t2 = {new TripletSelect(1, 9, 3), new TripletSelect(1, 0, 3), 
                        new TripletSelect(1, 2, 3), new TripletSelect(1, 7, 3)}; //9 0 2 7
        TripletSelect[] t3 = {new TripletSelect(1, 2, 3), new TripletSelect(1, 6, 3), 
                        new TripletSelect(1, 5, 3), new TripletSelect(1, 3, 3)}; //2 6 5 3
        TripletSelect[] t4 = {new TripletSelect(1, 7, 3), new TripletSelect(1, 6, 3), 
                        new TripletSelect(1, 3, 3), new TripletSelect(1, 1, 3)}; //7 6 3 1
        int[] e1 = {2, 0, 4, 5};
        int[] e2 = {9, 0, 2, 7};
        int[] e3 = {2, 6, 5, 3};
        int[] e4 = {7, 6, 3, 1};
        t.checkExpect(getBs(t1), e1);
        t.checkExpect(getBs(t2), e2);
        t.checkExpect(getBs(t3), e3);
        t.checkExpect(getBs(t4), e4);
    }
}