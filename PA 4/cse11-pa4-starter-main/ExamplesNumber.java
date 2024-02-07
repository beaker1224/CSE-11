import tester.*;

interface Number {
   public int numerator();
   public int denominator();
   public Number add(Number other);
   public Number multiply(Number other);
   public Number getMax(Number other);
   public String toString();
   public double toDouble();
}

class WholeInteger implements Number{
    int n;
//Constructor -----------------------------------
WholeInteger(int n){
    this.n = n;
}
//Methods ------------------------------------------
public int numerator(){
    return this.n;
}
public int denominator(){
    return 1;
}
public Number add(Number other){
    if(this.denominator() == other.denominator()){
        return new WholeInteger(this.numerator()/this.denominator() + other.numerator()/other.denominator());
    }else{
        int commom = this.denominator() * other.denominator();
        int thisn = this.numerator() * other.denominator();
        int othern = this.denominator() * other.numerator();
        return new Fraction((thisn + othern), commom);
    }
}
public Number multiply(Number other){
    if(this.denominator() == other.denominator()){
        return new WholeInteger(this.numerator()/this.denominator() * other.numerator()/other.denominator());
    }else{
        int nn = this.numerator() * other.numerator();
        int dd = this.denominator() * other.denominator();
        return new Fraction(nn, dd); 
    }
}
public Number getMax(Number other){
    double n1 = this.numerator()/this.denominator();
    double n2 = other.numerator()/other.denominator();
    if(n1 >= n2){
        return this;
    }else{
        return other;
    }
}
public String toString(){
    return this.n + "";
}
public double toDouble(){
    return (double) this.n;
}
}
//class =======================================================================================================
class Fraction implements Number{
int n;
int d;
//Constructor --------------------------
Fraction(int n, int d){
    this.n = n;
    this.d = d;
}
//Methods ------------------------------------
public int numerator(){
    return this.n;
}
public int denominator(){
    return this.d;
}
public Number add(Number other){
    if(other.numerator() != 0){
        int commom = this.denominator() * other.denominator();
        int thisn = this.numerator() * other.denominator();
        int othern = this.denominator() * other.numerator();
        return new Fraction((thisn + othern), commom);
    }else{
        return new Fraction(this.numerator(), this.denominator());
    }
}
public Number multiply(Number other){
        int nn = this.numerator() * other.numerator();
        int dd = this.denominator() * other.denominator();
        return new Fraction(nn, dd); 
}
public Number getMax(Number other){
    int thisn = this.numerator() * other.denominator();
    int othern = this.denominator() * other.numerator();
    if(thisn >= othern){
        return new Fraction(this.numerator(), this.denominator());    
    }else{
        if(other.denominator() == 1){
            return new WholeInteger(other.numerator());
        }else{
            return new Fraction(other.numerator(), other.denominator());
        }
        
    }
}
public String toString(){
    return this.n + "/" + this.d;
}
public double toDouble(){
    return (double) this.n / this.d;
}
}

class ExamplesNumber{
    Number ians1 = new WholeInteger(20);
    Number ians2 = new WholeInteger(13);
    Number ians3 = new WholeInteger(25);
    Number ians4 = new WholeInteger(78);
    Number ians5 = new WholeInteger(0);
    Number fans1 = new Fraction(0,10);//0
    Number fans2 = new Fraction(20,10);//2
    Number fans3 = new Fraction(5,10);//0.5
    Number fans4 = new Fraction(7,10);//7/10
    Number fans5 = new Fraction(2,7);//2/7
    void testNumbers(Tester t){
        //Whole number testing
        t.checkExpect(this.ians1.numerator(), 20);
        t.checkExpect(this.ians3.denominator(), 1);
        t.checkExpect(this.ians1.add(ians2).numerator(), 33);
        t.checkExpect(this.ians3.multiply(ians1).numerator(), 500);
        t.checkExpect(this.ians3.getMax(ians4).toString(), "78");
        t.checkExpect(this.ians1.toString(), "20");
        t.checkExpect(this.ians1.toDouble(), 20.0);
        //Fraction number testing
        t.checkExpect(this.fans1.numerator(), 0);
        t.checkExpect(this.fans2.denominator(), 10);
        t.checkExpect(this.fans3.add(fans2).toString(), "250/100");
        t.checkExpect(this.fans4.multiply(fans3).toString(), "35/100");
        t.checkExpect(this.fans5.getMax(fans4).toString(), "7/10");
        t.checkExpect(this.fans3.toString(), "5/10");
        t.checkExpect(this.fans3.toDouble(), 0.5);
        //testing for both
        t.checkExpect(this.ians2.getMax(fans4).toString(), "13");
        t.checkExpect(this.ians5.getMax(fans5).toString(), "2/7");
        t.checkExpect(this.fans3.getMax(ians4).toString(), "78");
    }


//Exploration
    double ex1 = 0.1 + 0.2 + 0.3;
    double ex2 = 0.1 + (0.2 + 0.3);
    Number pt1 = new Fraction(1, 10);
    Number pt2 = new Fraction(2, 10);
    Number pt3 = new Fraction(3, 10);
    String ex3 = pt3.add(pt2.add(pt1)).toString();
    String ex4 = pt1.add(pt2.add(pt3)).toString();
}

