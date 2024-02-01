import tester.*;

class DesignRecipeExamples {
//problem 1: Volume
    int volume(int length, int width, int height){
return length * width * height;
    }

 int ans1_1 = volume(1,2,3); //should be 6
 int ans1_2 = volume(3,2,3); //should be 18

//problem 2: Quadratic Equation
    int quadraticEquation(int a, int b, int c, int x){
            return a*x*x + b*x + c;
        }
 int ans2_1 = quadraticEquation(2,1,5,0); //should be 5
 int ans2_2 = quadraticEquation(2,1,10,0); //should be 10
 int ans2_3 = quadraticEquation(1,1,0,2); //should be 6

//problem 3: Converter
//this is a converter that converts temperature in Fahrenheit into Celsius by intake a integer Fahrenheit degree.
int FtoC(int TempInF){
    return (TempInF - 32) * 5 / 9;
    //this convertion came from https://www.google.com/search?q=Fahrenheit+to+Celsius&sourceid=chrome&ie=UTF-8
}
//the int type in java always truncate the decimal part
 int ans3_1 = FtoC(0); //should be -17, the actual result is -17.7778 by Google
 int ans3_2 = FtoC(41); //should be 5, the actual result is 5 by Google

//problem 4
//This combiner intakes hours and minutes as integers, output an integer value that shows focus time. Source from my brain.
int FocusTimeInMinutes(int hours, int minutes){
    return hours * 60 + minutes;
}

int ans4_1 = FocusTimeInMinutes(2,30);//expected to be 150
int ans4_2 = FocusTimeInMinutes(1,5);//expected to be 65
int ans4_3 = FocusTimeInMinutes(2,3000);//expected to be 3120
//I believe no input will produce an incorrect output but still runs. If the input is not integer, the program cannot run.
//since the method is only addition and multiplication, there should not be any incorrect output with correct input.
}
