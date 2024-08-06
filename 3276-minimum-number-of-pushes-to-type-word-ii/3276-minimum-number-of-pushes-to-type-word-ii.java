class Solution {
    class Pair{
        int count;
        Character ch;

        Pair(int count,Character ch){
            this.count=count;
            this.ch=ch;
        }

    }
    public int minimumPushes(String word) {
       int array[]=new int[26];
      for(int i=0;i<word.length();i++)
      {
         array[word.charAt(i)-'a']++;
      }
      PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->b.count-a.count);
      for(int i=0;i<array.length;i++){
          if(array[i]>0){
            Character ch=(char)(i+97);
            pq.add(new Pair(array[i],ch));
          }
      }
      //HashMap<Character,Integer>map=new HashMap<>(); 
      int count=0;
      int ans=0;
      while(!pq.isEmpty()){
        Pair p=pq.remove();
        //System.out.println(p.count+"  "+p.ch);
        int num=count/8;
        ans+=p.count*(num+1);
        count++;

      }
      return ans;


    }
}