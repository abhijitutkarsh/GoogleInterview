class Solution {
    public boolean isSubsequence(String s, String word){

        int i = 0 ;
        
        for(int k = 0 ; k< s.length(); k++)
        {
            if(word.length() == i)
            return true;
            
            if(word.charAt(i) == s.charAt(k) )
            {
             i++;
            }
        }

        return word.length() == i;
    }

    public int numMatchingSubseq(String s, String[] words) {
        
        int result = 0;
        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0 ; i< words.length; i++)
        {
            if(!map.containsKey(words[i]))
            {
                map.put(words[i], isSubsequence(s,words[i]));
            }
            
            if(map.get(words[i]) == true)
            {
                result++;
            }
        }
        return result;
    }
}