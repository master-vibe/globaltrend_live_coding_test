public class Knapsack {
    static int knapsack(int[] weight, int values[],int capacity){
        int n = weight.length;
        int[][] arr = new int[n+1][capacity+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=capacity;j++){
                if(i==0 || j==0)arr[i][j]=0;
                else if (weight[i-1]<=j) {
                    arr[i][j]=Math.max(values[i-1]+arr[i-1][j-weight[i-1]],arr[i-1][j]);
                }
                else {
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[n][capacity];
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3};
        int[] values = {10,15,40};
        int max_value = knapsack(weights,values,6);
        System.out.println("Maximun Value : "+max_value);
    }
}
