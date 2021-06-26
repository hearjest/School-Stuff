import java.util.*;
public class main
{
    main()
    {
        Queue row=new LinkedList<Integer>();
       
        System.out.println(row.size());
        /*for(int i=0;i<20;i++){
            System.out.println(1 + (int)(10 * Math.random()));
        }
         *ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(10,15,20,25,30));
        insert(list,31);
        System.out.println(list); 
         * Point[][] mat=new Point[8][10];
         * for(int r=0;r<mat.length;r++){
        for(int c=0;c<mat[r].length;c++){
        mat[r][c]=new Point(-1,91);
        }
        }
        for(Point[] row:mat){
        for(Point p:row){
        if(p.getX()<0||p.getY()<0){
        p.setLocation(0,0);
        }
        }
        }for(int c=0;c<mat[0].length;c++){
        for(int r=0;r<mat.length;r++){
        if(mat[r][c].getX()<0||mat[r][c].getY()<0){
        mat[r][c].setLocation(0,0);
        }
        }
        }

        int[][] mat=new int[8][10];
        for(int r=0;r<mat.length;r++){
        for(int c=0;c<mat[r].length;c++){
        mat[r][c]=-2;
        }
        }

        for(int[] row:mat){
        System.out.println("BOOM");
        for(int element:row){
        System.out.println("here1");
        if(element<0){
        element=0;
        System.out.println("here2");
        }
        }
        }

        for(int c=0;c<mat[0].length;c++){
        for(int r=0;r<mat.length;r++){
        if(mat[r][c]<0){
        mat[r][c]=0;
        }
        }
        }*/

        /*
         * 
        ArrayList<String> stringList=new ArrayList<String>();
        String ch=" ";
        Integer int0b=new Integer(5);
        stringList.add(int0b.toString());

        int[] arr={0,6,0,4,0,0,2};
        int count=0;
        for(int i=0;i<arr.length;i++){
        if(arr[i]!=0){
        arr[count]=arr[i];
        count++;
        }
        }
        int[] arr2=new int[count];
        for(int i=0;i<count;i++){
        arr2[i]=arr[i];
        }
        System.out.println(Arrays.toString(arr2));

        int[] arr={1,2,3,4,5};
        int sum=arr[0],i=0;

        while(i<arr.length){
        i++;
        sum+=arr[i];
        }
        System.out.println(sum);*/
    }

    public void insert(ArrayList<Integer> list, 
    int element){

        int index = 0; 
        while (element>list.get(index)){
            index++;
        }
        list.add(index, element); 
    }

}
