/*FindPairs: 
Write a Java program to find all pairs of elements in an 
array whose sum is equal to a specified number. 
Ex   a = [9, 1, 3, 22, 76, 15, 23, 7, 10, 8, 15, 4, 20, 5, 12, 2, 18]
K = 16      Pairs =  (9,7), (15, 1), (4,12)
K = 30      Pairs =  (22,8), (23,7), (10,20), (12,18)
K = 50       Pairs  = None
 */
public class findPairs
{
    public findPairs()
    {
        int a[]={9, 1, 3, 22, 76, 15, 23, 7, 10, 8, 15, 4, 20, 5, 12, 2, 18};
        int b[]={15,1485,150,1350,315,1185};
        //1500
        findPairsK(a, 50);
    }

    public static void findPairsK(int a[],int k){
        System.out.print("Pairs = ");
        String pairs="";
        //Should print "none" if no pairs
        for(int i=0;i<a.length-1;i++){
            if(a[i]<k){
                int num=a[i];
                for(int j=i+1;j<a.length;j++){
                    if(num+a[j]==k&&num!=a[j]&&!pairs.contains(""+a[j])){
                        pairs+="(" + num + "," + a[j]+") ";
                    }
                }
            }
        }
        if(pairs.equals("")){
            System.out.println("None");
        }else{
            System.out.println(pairs);
        }
    }

}
