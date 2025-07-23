class Solution {
    public int maximumGain(String s, int x, int y) {

        //choosing 'ab' or 'ba' substrings to remove from string depending on the higher value of x or y.
        //Greedy Approach

        //if x > y -> 'ab'
        char firstChar = 'a';
        char secondChar = 'b';
        // firstChar and secondChar for 'ab' - Assuming x > y
        int firstPairPoint = x;
        int secondPairPoint = y;

        //if y > x -> 'ba'
        if(y > x){
            firstChar = 'b';
            secondChar = 'a';
            // firstChar and secondChar for 'ba' - because y > x
            firstPairPoint = y;
            secondPairPoint = x;
        }

        //Will push the current item in the stack/StringBuilder as see if the last element is the
        //firstChar from the Stack and the currentChar of the String is the secondChar, then we can add
        //the firstPairPoint to the total score
        int totalPoints = 0;

        //StringBuilder pretending as Stack because we can remove the last element, fetch the last element
        StringBuilder sb1 = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(sb1.length() > 0 && sb1.charAt(sb1.length()-1) == firstChar && s.charAt(i) == secondChar){
                sb1.deleteCharAt(sb1.length()-1);
                totalPoints += firstPairPoint;
            } else {
                sb1.append(s.charAt(i));
            }
        }

        //Now for the remaining string we will do the reverse calaculation, Assume we got 'ab' as priority
        //then now will also have to check for 'ba' to add to the totalPoints, 'ab' calculation is done
        //above, so we will now calculate 'ba' in similar way just that we will checking in reverse
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<sb1.length(); i++){
            if(sb2.length() > 0 && sb2.charAt(sb2.length()-1) == secondChar && sb1.charAt(i) == firstChar){
                sb2.deleteCharAt(sb2.length()-1);
                totalPoints += secondPairPoint;
            } else {
                sb2.append(sb1.charAt(i));
            }
        }

        return totalPoints;
    }
}