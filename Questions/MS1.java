public class MS1 {

    public static int [] fibArr;
    public static void main(String [] args){

        fibArr = new int [10000];
        System.out.println(getFibo(5));
        System.out.println(getFibo(2));
        System.out.println(getFibo(10));
        System.out.println(getFibo(7));
        System.out.println(getFibo(6));

    }


    public static int getFibo(int n){
        if(fibArr[n]!=0){
            return fibArr[n];
        }else {
            if (n == 1 || n == 2) {
                return 1;
            }
            fibArr[n] = getFibo(n - 1) + getFibo(n - 2);
            return fibArr[n];
        }
    }

}


/*




 */


















/*
steps
use case  =>
=>

[10:02] Kumar Shiv Subramanyam





[10:02] Kumar Shiv Subramanyam

Flow.yaml

	Activity1:
	  - Step1
		Task11
	  - step2
	    Activity2:
	  	- Task21

	Activity3:
	   - Task31
	   - Task32



	Activiuty have multiple step

	list<steps>
	Dpenedency List
	Activity => List<Activities>



	Activity
	    List<Task>
	    List<Activity>

	 DAG
	a1 =>[a2, a4]
	a3 =>[]

	a1  =>

	stack <Activity>

   a1



   a4  => a2  =>  a1 =>


   a1  =>

   a2  =>
   => a3



   [
    =>
   ]

























has context menu







 */

/*



 1 1 2 3 5



 */