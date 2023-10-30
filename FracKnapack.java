package DAA;

import java.util.Arrays;

public class FracKnapack {
    public static void main(String args[]){
        int capacity =10;
        int weight[]={3,3,2,5,1};
        int value[]={10,15,10,12,8};
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
