import java.util.*;
public class main
{

    public main()
    {
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(2);
        q.add(8);
        q.add(-5);
        q.add(19);
        q.add(7);
        q.add(3);
        q.add(24);
        q.add(42);
        /*q.add(90);
        q.add(16);
        q.add(37);*/
        Stack<Integer> d=new Stack<Integer>();
        d.push(2);
        d.push(8);
        d.push(3);
        d.push(19);
        d.push(2);
        d.push(3);
        d.push(2);
        d.push(7);
        d.push(12);
        d.push(-8);
        d.push(4);
        /*d.push(6);
        d.push(6);
        d.push(17);
        d.push(17);
        d.push(3);
        d.push(10);
        d.push(5);
        d.push(1);*/

        System.out.println();
        interleave(q);
        System.out.println(q);

    }

    /*
    Write a method called interleave that accepts a queue of integers as a parameter and rearranges the elements by
    alternating the elements from the first half of the queue with those from the second half of the queue. For example, if
    the queue stores [2, 8, -5, 19, 7, 3, 24, 42], your method should change it to store [2, 7, 8, 3, -5,
    24, 19, 42]. To understand the result, consider the two halves of this queue. The first half is [2, 8, -5, 19] and
    the second half is [7, 3, 24, 42]. These are combined in an alternating fashion to form a sequence of pairs: the
    first values from each half (2 and 7), then the second values from each half (8 and 3), and so on. Your method should
    throw an IllegalArgumentException if the queue does not have an even size. Use one stack as auxiliary storage.
     */
    public static void interleave(Queue<Integer> q){
        if(q.size()%2!=0){
            throw new IllegalArgumentException();
        }
        Stack<Integer> s=new Stack<Integer>();
        int size=q.size(),n;

        for(int i=0;i<size;i++){
            n=q.remove();
            if(i>=size/2){
                s.push(n);
            }else{
                q.add(n);
            }
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        for(int i=0;i<size/2;i++){
            q.add(q.remove());
        }
        for(int i=0;i<size/2;i++){
            s.push(q.remove());
        }
        size=q.size();
        for(int i=0;i<size;i++){
            q.add(q.remove());
            q.add(s.pop());
        }
    }

    /*
    Write a method called removeMin that accepts a stack of integers as a parameter and removes and returns the smallest value from the stack. For example, if the stack stores [2, 8, 3, 19, 2, 3, 2, 7, 12, -8, 4], your
    method should remove and return -8, leaving the stack storing [2, 8, 3, 19, 2, 3, 2, 7, 12, 4]. If the minimum value appears more than once, all occurrences of it should be removed. For example, given the same stack, if
    we again call removeMin on it, the method would return 2 and leave the stack storing [8, 3, 19, 3, 7, 12, 4].
    Use one queue as auxiliary storage.
     */
    public static void removeMin(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<Integer>();
        int n,min=s.pop();q.add(min);

        while(!s.isEmpty()){
            n=s.pop();
            if(min>n){
                min=n;
            }
            q.add(n);
        }

        while(!q.isEmpty()){
            n=q.remove();
            if(n!=min){
                s.push(n);
            }
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }

    }

    /*
    Write a method called mirrorHalves that accepts a queue of integers as a parameter and replaces each half of that
    queue with itself plus a mirrored version of itself (the same elements in the opposite order). For example, if the
    queue stores [10, 50, 19, 54, 30, 67], your method should change it to store [10, 50, 19, 19, 50, 10,
    54, 30, 67, 67, 30, 54]. If your method is passed an empty queue, the result should be an empty queue. If
    your method is passed a queue whose size is not even, throw an IllegalArgumentException. Use one stack or
    one queue (but not both) as auxiliary storage.
     */
    public static void mirrorHalves(Queue<Integer> q){
        if(q.size()%2!=0){
            throw new IllegalArgumentException();
        }
        Stack<Integer> s=new Stack<Integer>();
        int n, size=q.size()/2;
        for(int i=0;i<size;i++){
            n=q.remove();
            q.add(n);
            s.push(n);
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        for(int i=0;i<size;i++){
            n=q.remove();
            q.add(n);
            s.push(n);
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    /*
    Write a method called compressDuplicates that accepts a stack of integers as a parameter and that replaces each
    sequence of duplicates with a pair of values: a count of the number of duplicates, followed by the actual duplicated
    number. For example, if the stack stores [2, 2, 2, 2, 2, -4, -4, -4, 82, 6, 6, 6, 6, 17, 17], your
    method should change it to store [5, 2, 3, -4, 1, 82, 4, 6, 2, 17]. This new stack indicates that the original had 5 occurrences of 2 at the bottom of the stack followed by 3 occurrences of -4 followed by 1 occurrence of
    82, and so on. If the stack is empty, your method should not change it. Use one queue as auxiliary storage.
     */
    public static void compressDuplicates(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        Queue<Integer> q=new LinkedList<Integer>();
        int count=0,n;

        while(!s.isEmpty()){
            n=s.pop();
            count++;
            if((!s.isEmpty()&&n!=s.peek())||s.isEmpty()){
                q.add(n);
                q.add(count);
                count=0;

            }
        }
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        while(!q.isEmpty()){
            s.push(q.remove());
        }
    }

    /*
    Write a method called mirror that accepts a stack of integers as a parameter and replaces the stack contents with
    itself plus a mirrored version of itself (the same elements in the opposite order). For example, if the stack stores
    Programming Projects 905
    [10, 53, 19, 24], your method should change it to store [10, 53, 19, 24, 24, 19, 53, 10]. If passed an
    empty stack, your result should be an empty stack. Use one stack or one queue (but not both) as auxiliary storage to
    solve this problem.
     */
    public static void mirror(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<Integer>();
        int size;
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        size=q.size();
        for(int i=0;i<size;i++){
            s.push(q.peek());
            q.add(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        for(int i=0;i<size;i++){
            q.add(q.remove());
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }
    }

    /*
    Write a method called isSorted that accepts a stack of integers as a parameter and returns true if the elements in
    the stack occur in ascending (nondecreasing) order from top to bottom. That is, the smallest element should be on
    top, growing larger toward the bottom. For example, if the stack stores [20, 20, 17, 11, 8, 8, 3, 2], your
    method should return true. An empty or one-element stack is considered to be sorted. Your method must restore the
    parameter stack to its original state before returning. Use one queue or stack (but not both) as auxiliary storage.
     */
    public static boolean isSorted(Stack<Integer> s){
        Stack<Integer> s1=new Stack<Integer>();
        boolean sorted=true; int n=s.pop();s1.push(n);
        int size=s.size()-1;
        for(int i=0;i<size;i++){
            if(n>s.peek()){
                sorted=false;
            }

            n=s.pop();
            s1.push(n);
        }

        while(!s1.isEmpty()){
            s.push(s1.pop());
        }

        return sorted;
    }

    /*
    Write a method called reverseFirstK that accepts an integer k and a queue of integers as parameters and reverses the
    order of the first k elements of the queue, leaving the other elements in the same relative order. For example, if a queue
    named q stores [10, 20, 30, 40, 50, 60, 70, 80, 90], the call of reverseFirstK(4, q); should change
    the queue to store [40, 30, 20, 10, 50, 60, 70, 80, 90]. If k is 0 or negative, no change should be made. If
    the queue does not contain at least k elements, your method should throw an IllegalArgumentException. Use one
    queue or stack (but not both) as auxiliary storage.
     */
    public static void reverseFirstK(Queue<Integer> q, int k){
        Stack<Integer> s=new Stack<Integer>();

        for(int i=0;i<k;i++){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        for(int i=0;i<q.size()-k;i++){
            q.add(q.remove());
        }
    }

    /*
    . Write a method called expunge that accepts a stack of integers as a parameter and makes sure that the stack’s elements are in nondecreasing order from top to bottom, by removing from the stack any element that is smaller than
    any element(s) on top of it. For example, if the stack stores [4, 20, 15, 15, 8, 5, 7, 12, 3, 10, 5, 1],
    the element values 3, 7, 5, 8, and 4 should be removed because each has an element above it with a larger
    value. So your method should change the stack to store [20, 15, 15, 12, 10, 5, 1]. Notice that now the elements are in nondecreasing order from top to bottom. If the stack is empty or has just one element, nothing changes.
    Use one queue or stack (but not both) as auxiliary storage.
     */
    public static void expunge(Stack<Integer> s){
        Stack<Integer> s1=new Stack<Integer>();
        int size=s.size();int n=s.pop();s1.push(n);

        for(int i=0;i<size-1;i++){

            if(n<=s.peek()){
                n=s.pop();
                s1.push(n);
            }else{
                s.pop();

            }

        }

        while(!s1.isEmpty()){
            s.push(s1.pop());
        }
    }

    /*
    Write a method called shift that accepts a stack of integers and an integer n as parameters and that shifts n values
    from the bottom of the stack to the top of the stack. For example, if the stack named s stores [1, 2, 3, 4, 5, 6,
    7, 8], and we make the call shift(s, 3); your method should shift the three values at the bottom of the stack to
    the top of the stack and leave the other values in the same order, producing [4, 5, 6, 7, 8, 3, 2, 1]. Notice
    that the value that was at the bottom of the stack is now at the top, the value that was second from the bottom is now
    second from the top, the value that was third from the bottom is now third from the top, and that the five values not
    involved in the shift are now at the bottom of the stack in their original order. Use one queue as auxiliary storage.
    You may assume that the parameter n is / 0 and not larger than the number of elements in the stack.
     */
    public static void shift(Stack<Integer> s,int k){
        Queue<Integer> q=new LinkedList<Integer>();
        int size=s.size();

        for(int i=0;i<size-k;i++){
            q.add(s.pop());
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }

    }

    /*
    . Write a method called reorder that accepts a queue of integers as a parameter and that puts the integers into sorted
    (nondecreasing) order, assuming that the queue is already sorted by absolute value. For example, if the queue stores
    [1, 2, -2, 4, -5, 8, -8, 12, -15], notice that the values appear in sorted order if you ignore the sign of the
    numbers. Your method should reorder the values so that the queue stores [-15, -8, -5, -2, 1, 2, 4, 8, 12].
    Use one stack as auxiliary storage.  
     */
    public static void reorder(Queue<Integer> q){
        Stack<Integer> s=new Stack<Integer>();
        int size=q.size();int n;
        for(int i=0;i<size;i++){
            n=q.remove();
            if(n<0){
                s.push(n);
            }else{
                q.add(n);
            }
        }
        size=q.size();
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        for(int i=0;i<size;i++){
            q.add(q.remove());
        }
    }

    /*
    Write a method called isConsecutive that accepts a stack of integers as a parameter and that returns true if the
    stack contains a sequence of consecutive integers starting from the bottom of the stack. Consecutive integers are
    integers that come one after the other, as in 3, 4, 5, etc. If the stack stores [5, 6, 7, 8, 9, 10], your method
    should return true. If the stack had instead contained [7, 8, 9, 10, 12], your method should return false
    because the numbers 10 and 12 are not consecutive. Notice that we look at the numbers starting at the bottom of the
    stack. Any stack with fewer than two values should be considered to be a list of consecutive integers. Your method
    must restore the parameter stack to its original state before returning. Use one queue as auxiliary storage
     */
    public static boolean isConsecutive(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<Integer>();
        boolean consec=true;int n;

        while(!s.isEmpty()){
            n=s.pop();
            if(!s.isEmpty()&&n-1!=s.peek()){
                consec=false;
            }
            q.add(n);
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());

        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }
        return consec;
    }

    public static void switchPairs(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<Integer>();
        int n=0,n2,n3,size=s.size();
        if(size%2!=0){
            n=s.pop();
        }

        while(!s.isEmpty()){
            n2=s.pop();
            n3=s.pop();
            q.add(n3);
            q.add(n2);
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        if(size%2!=0){
            s.push(n);
        }
    }

    public static boolean isPalindrome(Queue<Integer> q){
        Stack<Integer> s=new Stack<Integer>();
        int n,n2;boolean isEqual=true;
        for(int i=0;i<q.size();i++){
            n=q.remove();
            s.push(n);
            q.add(n);
        }

        for(int i=0;i<q.size();i++){
            n=q.remove();
            n2=s.pop();
            if(n!=n2){
                isEqual=false;
            }
            q.add(n);
        }

        return isEqual;
    }

    /*
    Write a method called reverseHalf that accepts a queue of integers as a parameter and reverses the order of all the
    elements in odd-numbered positions (position 1, 3, 5, etc.), assuming that the first value in the queue has position 0.
    For example, if the queue stores [1, 8, 7, 2, 9, 18, 12, 0], your method should change it to store [1, 0,
    7, 18, 9, 2, 12, 8]. Notice that numbers in even positions (positions 0, 2, 4, 6) have not moved. That subsequence of integers is still (1, 7, 9, 12). But notice that the numbers in odd positions (positions 1, 3, 5, 7) are now in
    reverse order relative to the original. In other words, the original subsequence (8, 2, 18, 0) has become (0, 18, 2, 8).
    Use a single stack as auxiliary storage.
     */
    public static void reverseHalf(Queue<Integer> q){
        Stack<Integer> s=new Stack<Integer>();
        int count=0;int size=q.size();

        for(int i=0;i<size;i++){
            if(count%2==0){
                q.add(q.remove());
            }else{
                s.push(q.remove());
            }
            count++;
        }

        while(!s.isEmpty()){
            q.add(q.remove());
            q.add(s.pop());
        }

    }

    /*
    Write a method called rearrange that accepts a queue of integers as a parameter and rearranges the order of the
    values so that all of the even values appear before the odd values and that otherwise preserves the original order of
    the queue. For example, if the queue stores [3, 5, 4, 17, 6, 83, 1, 84, 16, 37], your method should
    rearrange it to store [4, 6, 84, 16, 3, 5, 17, 83, 1, 37]. Notice that all of the evens appear at the front
    followed by the odds and that the relative order of the evens and odds is the same as in the original. Use one stack as
    auxiliary storage.
     */
    public static void rearrange(Queue<Integer> q){
        Stack<Integer> s=new Stack<Integer>();
        int size=q.size();int n;
        for(int i=0;i<size;i++){
            n=q.remove();
            if(n%2!=0){
                s.push(n);
            }else{
                q.add(n);
            }
        }
        size=q.size();
        while(!s.isEmpty()){
            q.add(s.pop());
        }

        for(int i=0;i<size;i++){
            n=q.remove();
            if(n%2==0){
                s.push(n);
            }
            if(q.peek()%2!=0){
                break;
            }
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    /*
    Write a method called equals that accepts two stacks of integers as parameters and returns true if the two stacks
    store exactly the same sequence of integer values in the same order. Your method must restore the two stacks to their
    original state before returning. Use one stack as auxiliary storage.
     */
    public static boolean equals(Stack<Integer> s1,Stack<Integer> s2){
        if(s1.size()!=s2.size()){
            return false;
        }
        boolean isEqual=true; int n;
        Stack<Integer> copy =new Stack<Integer>();

        while(isEqual&&!s1.isEmpty()){
            if(s1.peek()==s2.peek()){
                copy.push(s1.pop());
                s2.pop();
            }else{
                isEqual=false;
            }
        }

        while(!copy.isEmpty()){
            n=copy.pop();
            s1.push(n);
            s2.push(n);
        }
        return isEqual;
    }

    /*
    Write a method called collapse that accepts a stack of integers as a parameter and that collapses it by replacing each
    successive pair of integers with the sum of the pair. For example, if the stack stores [7, 2, 8, 9, 4, 11, 7, 1,
    42], the first pair should be collapsed into 9 (7 + 2), the second pair should be collapsed into 17 (8 + 9), and so on. If
    the stack stores an odd number of elements, such as the 42 at the end of our example stack, the final element is not
    collapsed. So for this stack your method would yield [9, 17, 15, 8, 42]. Use one queue as auxiliary storage.
     */
    public static void collaspe(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<Integer>();
        int size;
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        size=q.size();
        for(int i=0;i<size-(size%2);i+=2){
            s.push(q.remove()+q.remove());
        }
        if(size%2>0){
            s.push(q.remove());
        }

    }

    /*
    Write a method called copyStack that accepts a stack of integers as a parameter and returns a copy of the original
    stack (i.e., a new stack with the same values as the original, stored in the same order as the original). Your method
    should create the new stack and fill it up with the same values that are stored in the original stack. When your
    method is done executing, the original stack must be restored to its original state. Use one queue as auxiliary storage.
     */
    public static Stack<Integer> copyStack(Stack<Integer> s){
        Stack<Integer> copy =new Stack<Integer>();
        Queue<Integer> q=new LinkedList<Integer>();
        int n;

        while(!s.isEmpty()){
            copy.push(s.pop());
        }
        while(!copy.isEmpty()){
            q.add(copy.pop());
        }
        while(!q.isEmpty()){
            n=q.remove();
            copy.push(n);
            s.push(n);
        }

        System.out.println("copy = " +copy);
        return copy;
    }

    /*
    Write a method called stutter that accepts a stack of integers as a parameter and replaces every value in the stack
    with two occurrences of that value. Preserve the original relative order. For example, if the stack stores [3, 7, 1,
    14, 9], your method should change it to store [3, 3, 7, 7, 1, 1, 14, 14, 9, 9]. Use a single queue as
    auxiliary storage.
     */
    public static void stutter(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<Integer>();

        int size=s.size();
        for(int i=0;i<size;i++){
            q.add(s.pop());
        }

        while(!q.isEmpty()){
            int n=q.remove();
            s.push(n);
            s.push(n);
        }
    } 

    /*
    Write a method called splitStack that accepts a stack of integers as a parameter and rearranges its elements so
    that all the negatives appear on the bottom of the stack and all the nonnegatives appear on the top. If after this
    Exercises 903
    method is called you were to pop numbers off the stack, you would first get all the nonnegative numbers and then get
    all the negative numbers. It does not matter what order the numbers appear in as long as all the negatives appear
    lower in the stack than all the nonnegatives. For example, if the stack stores [3, -5, 1, 2, -4], an acceptable
    result from your method would be [-5, -4, 3, 1, 2]. Use a single queue as auxiliary storage.
     */
    public static void splitStack(Stack<Integer> s){
        Queue<Integer> q=new LinkedList<Integer>();
        int size=s.size();
        for(int i=0;i<size;i++){
            q.add(s.pop());
        }
        size=q.size();
        for(int i=0;i<size;i++){
            int n=q.remove();
            if(n<0){
                s.push(n);
            }else{
                q.add(n);
            }
        }
        size=q.size();
        for(int i=0;i<size;i++){
            s.push(q.remove());
        }
        System.out.println(s);

    }
}
