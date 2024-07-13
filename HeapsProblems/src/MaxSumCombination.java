import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;
import java.util.PriorityQueue;


public class MaxSumCombination {
    public static void main(String[] args) {
        int[] A = { 1, 4, 2, 3 };
        int[] B = { 2, 5, 1, 6 };
        int[] res = solve(A, B, 4);
        System.out.println(Arrays.toString(res));
    }
     public static int[] solve(int[] A, int[] B, int C) {
        Arrays.sort(A) ;
        Arrays.sort(B) ;
        
        ArrayList<Integer> a = new ArrayList<>() ;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>() ;
        pq.add(new Pair(A.length-1,B.length-1, A[A.length-1]+B[B.length-1] ) );
        
        HashSet<Integer> hs = new HashSet<>() ;
        hs.add( f(A[A.length-1],B[B.length-1]) ) ;
         
        while(a.size()<C){
            Pair p = pq.remove() ;
            
            if( hs.contains( f(p.i,p.j) ) ) 
                continue ;
            else
                hs.add( f(p.i,p.j) ) ;
            
            a.add(p.wt) ; 
            
            if(p.i>0)
                pq.add(new Pair(p.i-1,p.j,A[p.i-1]+B[p.j]) ) ;
            if(p.j>0)
                pq.add(new Pair(p.i,p.j-1,A[p.i]+B[p.j-1]) ) ;
        }
        
        int[] r = new int[a.size()] ;
        for(int i=0;i<a.size();i++){
            r[i] = a.get(i) ;
        }
        
        return  r ;  
    }
    
    public static int f(int a,int b){
        return  a + ((a+b)*(a+b+1))/2 ; 
    }
    
    public static class Pair implements Comparable<Pair>{
        int i;
        int j;
        int wt;
        Pair(int i,int j,int wt){
            this.i = i ;
            this.j = j ;
            this.wt = wt ;
        }
        
        public int compareTo(Pair o){
            return o.wt-this.wt ;
        }
    }
   
}
