package DAA;
import java.util.*;
public class fibo{
    public static int fiboR(int num){
        if(num==0 || num==1){
            return num;
        }

        return fiboR(num-1)+fiboR(num-2);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the end number of series:");
        int num=sc.nextInt();
        sc.close();
        // Recursion
        long begin=System.currentTimeMillis();
        for(int i=0;i<num;i++){
            System.out.print(fiboR(i)+" ");
        }
        long end= System.currentTimeMillis();
        System.out.println();
        System.out.println("Total time taken:"+(end-begin)+" millis second");

        // Iterative
        long begin1=System.currentTimeMillis();
        int a=0;
        int b=1;
        int count=2;
        int c;
        System.out.print("0 1 ");
        while(count<num){
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
            count++;
        }
        long end1=System.currentTimeMillis();
        System.out.println();
        System.out.println("Total time taken:"+(end1-begin1)+" millis second");
    }
}