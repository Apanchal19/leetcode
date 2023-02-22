class Solution {
    public int lengthOfLongestSubstring(String s) {
        //creating the variables required
        //Two pointers-> left & right
        int left = 0 , right = 0;

        //Creating a set to store the non-duplicate elements.
        Set<Character> seen = new HashSet();          
        //Max variable to store the max length of the window
        int max = 0;

        //Right pointer will move
        while(right<s.length()){
            //character coming on right
            char c = s.charAt(right);
            //set mein agar character addd hora hai
            if(seen.add(c)){
               //window size comparing with math.max
               max = (Math.max(max, right - left + 1));
               //move forward
               right++;
           }//agar character add nahi hua set mein toh duplicate char mil hai
           else{
               //jabtak right char k barabar nahi hai tab tak chalega 
               while(s.charAt(left)!=c){
                   seen.remove(s.charAt(left));
                   left++;
               }
               //actual char remove karenge
               seen.remove(c);
               left++;
           }
        }
        return max;
    }
}