package bit.rigu.homework.lesson6;


import java.math.BigInteger;

public interface FibonacciData {

     void setNumberOfFibonacci(int numberOfFibonacci);

     int getNumberOfFibonacci();

     default boolean isNumberInMemory(){
         return true;
     };

     default void putFibonacciAtList(BigInteger fibonacci){
         System.out.println("In this class list of Fibonacci is not available");
     };

     default int getSizeOfList() {
         return 0;
     }

     default BigInteger getFibonacciByNumberFromList(int number) {
         return null;
     }

}
