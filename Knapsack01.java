package DAA;

import java.util.*;
public class Knapsack01 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of item:");
        int capacity =sc.nextInt();
        int weight[]=new int[capacity];
        int value[]=new int[capacity];
        for(int i=0;i<capacity;i++){
            System.out.println("Enter the weight and value of "+(i+1)+" element");
            weight[i]=sc.nextInt();
            value[i]=sc.nextInt();
        }
        int number=value.length;

        int k[][]=new int[number+1][capacity+1];

        for(int i=0;i<=number;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0 || j==0){
                    k[i][j]=0;
                }
                else if(weight[i-1]<=j){
                    k[i][j]=Math.max(value[i-1]+k[i-1][j-weight[i-1]], k[i-1][j]);
                }
                else{
                    k[i][j]=k[i-1][j];
                }
            }
        }

        System.out.println(k[number][capacity]);
    } 
}
