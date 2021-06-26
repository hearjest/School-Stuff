import java.util.*;
public class main
{
    public main()
    {
       /*Map<String,String> some=new HashMap<String,String>();
       some.put("boom","8-99");
       some.put("beep","1-68");
       some.put("floo","8-99");*/
       
       Map<String,Integer> map=new HashMap<String,Integer>();
       map.put("h",8);
       map.put("g",9);
       map.put("j",7);
       map.put("k",7);
       map.put("a",3);
       map.put("q",9);
       map.put("r",9);
       System.out.println(mystery6(5));
       /*Map<String,String> someThing=new HashMap<String,String>();
       someThing.put("42","marty");
       someThing.put("3","marty");
       someThing.put("81","sue");
       someThing.put("17","ed");
       someThing.put("31","dave");
       someThing.put("56","ed");
       someThing.put("29","ed");*/
       
    }
    
    
    public static void rarest(Map<String,Integer> map){
        Map<Integer,Integer> intCount=new HashMap<Integer,Integer>();
        Set<String> keyMap=new HashSet<String>(map.keySet());
        Iterator<String> it=keyMap.iterator();
        
           while(it.hasNext()){
            String next=it.next();
            if(!(intCount.containsKey(map.get(next)))){
                intCount.put(map.get(next),1);
                
            }else{
                int count=intCount.get(map.get(next))+1;
                intCount.put(map.get(next),count);
            }
        }
 
        Set<Integer> rarestSet=new HashSet<Integer>(intCount.keySet());
        Iterator<Integer> it2=rarestSet.iterator();
        int least=it2.next();
        while(it2.hasNext()){
            int now=it2.next();
            if(least>now&&intCount.get(least)>=intCount.get(now)){
                least=now;
            }
        }
        System.out.println(least);
    }
    
    public static void reverse(Map<String,String> map){ 
        Map<String,Set<String>> newMap=new HashMap<String,Set<String>>();
        Set<String> setValues=new HashSet<String>(map.values());
        Set<String> setKeys=new HashSet<String>(map.keySet());
        Iterator<String> it=setValues.iterator();
        
           while(it.hasNext()){//Goes through the values(Names)
            String next=it.next();
            Set<String> oldKey=new HashSet<String>();//Set to hold the numbers
                                                     //(original keys)
            for(String n:setKeys){//Check if next matches with any of 
                                    //the key's value (itself)
                if(next.equals(map.get(n))){//If next matches the key's value
                                            //Add the key to the set along with any
                                            //other matching key
                    oldKey.add(n);
                    newMap.put(next,oldKey);
                }
            }
        }
        System.out.println(newMap);
    }
    
    public static void subMap(Map<String,String> submap,Map<String,String> ogmap){
        Set<String> subMapSet=new HashSet<String>(submap.keySet());
        Iterator<String> it=subMapSet.iterator();
        while(it.hasNext()){
            String next=it.next();
            if(submap.get(next).equals(ogmap.get(next))){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
    
    public static void istol(Map<String,String> map){
        Set<String> set=new HashSet<String>(map.keySet());
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String next=it.next();
            String nextValue=map.get(next);
            map.remove(next);
            if(map.containsValue(nextValue)){
                System.out.println("False");
                return;
            }else{
                map.put(next,nextValue);
            }
        }
        System.out.println("True");
    }
    
    public static void maxOccurences(List<Integer> list){
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        Iterator<Integer> it=list.iterator();
        int numOfMax=0;
        int maxOccurences=0;
        while(it.hasNext()){
            int next=it.next();
            if(!map.containsKey(next)){
                map.put(next,1);
            }else{
                int count=map.get(next)+1;
                if(maxOccurences<count){
                    maxOccurences=count;
                    numOfMax=next;
                }
                map.put(next,count);
            }
        }
        System.out.println("Num is " + numOfMax + " Occurences: " + maxOccurences);
    }
    
    public static void intersetMap(Map<String,Integer> map1, Map<String,Integer> map2){
        Map<String,Integer> map3=new HashMap<String,Integer>();
        Set<String> set=new HashSet<String>(map1.keySet());
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String next=it.next();
            if(map1.get(next)==map2.get(next)&&map2.containsKey(next)){
                map3.put(next,map1.get(next));
            }
        }
        System.out.println(map3);
    }
    
    public static void isUnique(Map<String,String> map){
        Set<String> mapDupeSet=new HashSet<String>();
        Set<String> mapKey=new HashSet<String>(map.keySet());
        for(String n:mapKey){
            if(mapDupeSet.contains(map.get(n).toLowerCase())){
                System.out.println("False");
                return;
            }else{
                mapDupeSet.add(map.get(n).toLowerCase());
            }
        }
        System.out.println("true");
    }
    
    public static void contains3(List<String> list){
        Map<String,Integer> mapper=new TreeMap<String,Integer>();
        Iterator it=list.iterator();
        while(it.hasNext()){
            String next=it.next().toString().toLowerCase();
            if(mapper.containsKey(next)){
                int count=mapper.get(next)+1;
                if(count==3){
                    System.out.println("True");
                    return;
                }
                mapper.put(next,count);
            }else{
                mapper.put(next,1);
            }
        }
        System.out.println("False");
    }
    
    public static void symetricalDifference(Set<Integer> set1,Set<Integer> set2){
        Set<Integer> common=new TreeSet<Integer>(set1);
        common.addAll(set2);
        Iterator<Integer> it=common.iterator();
        while(it.hasNext()){
            int num=it.next();
            if(set1.contains(num)&&set2.contains(num)){
                it.remove();
            }
        }
        System.out.println(common);
    }
    
    public static void removeEvenLength(Set<String> set){
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            if(it.next().length()%2==0){
                it.remove();
            }
        }
        System.out.println(set);
    }
    
    public static boolean hasOdd(Set<Integer> set){
        boolean hasOdd=false;
        Iterator<Integer> it=set.iterator();
        while(it.hasNext()){
            if(it.next()%2!=0){
                hasOdd=true;
            }
        }
        return hasOdd;
    }
    
    public static int maxLength(Set<String> set){
        int length=0;
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            int setLength=it.next().length();
            if(setLength>length){
                length=setLength;
            }
        }
        return length;
    }
    
    public static void countCommon(List<Integer> list1, List<Integer> list2){
        int count=0;
        Set<Integer> ungaBunga=new TreeSet<Integer>(list1);
        ungaBunga.retainAll(list2);
        for(Integer n: ungaBunga){
            count++;
        }
        System.out.println(count);
    }
    
    public static void countUnique(List<Integer> list){
        int count=0;
        Set<Integer> uniqueSet=new TreeSet(list);
        for(Integer n:uniqueSet){
            count++;
        }
        System.out.println(count);
    }
    
    public static void sortAndRemoveDuplicates(List<Integer> list){
        Set<Integer> tree=new TreeSet<Integer>(list);
        System.out.println(tree);
    }
    
    public static void partition(List<Integer> list, int e){
        /*Iterator<Integer> it=list.iterator();
        List<Integer> lessE=new LinkedList<Integer>();
        while(it.hasNext()){
            int r=it.next();
            if(r<e){
                it.remove();
                lessE.add(r);
            }
        }
        for(int i=0;i<lessE.size();i++){
            list.add(0,lessE.get(i));
        }*/
        
        for(int i=0;i<list.size();i++){
            if(list.get(i)<e){
                int r=list.remove(i);
                
            }
        }
        System.out.println(list);
    }
    
    public static void removeInRange(LinkedList<Integer> list,int target,int startIndex,
    int endIndex){
        Iterator<Integer> it=list.iterator();
        int count=-1;
        while(it.hasNext()){
            count++;
            if(it.next()==target&&count>=startIndex&&count<endIndex){
                it.remove();
            }
        }
        System.out.println(list);
    }
                                     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void alternate(List<Integer> list1,List<Integer> list2){
        List<Integer> result=new LinkedList<Integer>();
        Iterator<Integer> n1=list1.iterator();
        Iterator<Integer> n2=list2.iterator();
        int count2=-1;
        while(n1.hasNext()){
            result.add(n1.next());
            System.out.println(result);
        }
        
        while(n2.hasNext()){
            if(list1.size()>=list2.size()){
                result.add(count2+2,n2.next());
                count2+=2;
                System.out.println(result);
                System.out.println("here1");
            }else if(result.size()<list1.size()+3){
                result.add(count2+2,n2.next());
                count2+=2;
                System.out.println(result);
                System.out.println("here2");
            }else{
                count2+=1;
                result.add(count2+1,n2.next());
                System.out.println(result);
                System.out.println("here3");
            }
            
        }
        System.out.println(result);
    }
}
