class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid: asteroids){
            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                int top = stack.pop();
                if(Math.abs(top) > Math.abs(asteroid)){
                    //top survives;
                    stack.push(top);
                    asteroid = 0; //the current asteroid destroyed
                } else if(Math.abs(top) == Math.abs(asteroid)){
                    //both of them destroyed
                    asteroid = 0;
                }
            }

            if(asteroid != 0){
                stack.push(asteroid);
            }
        }

        //convert stack into array;
        int[] result = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}