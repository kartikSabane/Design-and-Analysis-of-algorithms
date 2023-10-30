package DAA;

public class Knapsack01 {
    public static void main(String args[]){
        int capacity=50;
        int value[]={60,100,120};
        int weight[]={10,20,30};
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
