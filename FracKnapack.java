package DAA;

import java.util.*;

public class FracKnapack {
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of capacity:");
        int capacity=sc.nextInt();
        System.out.println("Enter the number of item:");
        int num =sc.nextInt();
        int weight[]=new int[num];
        int value[]=new int[num];
        for(int i=0;i<capacity;i++){
            System.out.println("Enter the weight and value of "+(i+1)+" element");
            weight[i]=sc.nextInt();
            value[i]=sc.nextInt();
        }
        double ratio[]=new double[value.length];

        //calculate value/weight
        for(int i=0;i<weight.length;i++){
            ratio[i]=value[i]/weight[i];
        }

        //Sort the ratio
        Arrays.sort(ratio);

        //Highest ratio add to knapsack
        double maxvalue=0;
        for(int i=0;i<ratio.length;i++){
            if(capacity==0){
                break;
            }

            if(weight[i]<capacity){
                maxvalue=maxvalue+value[i];
                capacity=capacity-weight[i];
            }else{
                double fraction=capacity/weight[i];
                maxvalue=maxvalue+fraction*value[i];
                capacity=0;
            }
        }
        System.out.println("Max Value is :"+maxvalue);
    }
}
