public class CodeSignal {
    public static void main(String [] args){
            int [] rates = {2, 4, 1, 5, 10, 6};
            int [] strategy = {-1, 1, 0, 1, -1, 0};
            int k = 4;
            int n = rates.length;
            int res=0;
            for(int j=0;j<=n-k;j++){
                int tmp =0;
                for(int i=0;i<j;i++){
                    tmp += fun(rates, i, strategy, tmp);
                    System.out.println("i = "+ i);
                    System.out.println("first tmp = "+ tmp);
                }
                int count=k/2;
                for(int i=j+count; i<j+k; i++){
                    tmp+=rates[i];
                    System.out.println("i = "+ i);
                    System.out.println("second tmp = "+ tmp);
                }
                for(int i=j+k; i<n; i++){
                    tmp += fun(rates, i, strategy, tmp);
                    System.out.println("i = "+ i);
                    System.out.println("third tmp = "+ tmp);
                }
                res=Math.max(res, tmp);
            }
        System.out.println("Result = "+res);
        }


        public static int fun(int [] rates, int indx, int [] strategy, int curr){
            if(strategy[indx]==-1){
                System.out.println(curr+".   "+rates[indx]);
                return rates[indx]*(-1);
            }else if(strategy[indx]==1){
                return rates[indx];
            }else{
                return 0;
            }
        }
/*
[2, 4, 1, 5, 10, 6]
[-1, 1, 0, 1, -1, 0]
*/
}
