class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[2051];

        for(int[] log: logs){
            int birth = log[0];
            int death = log[1];

            diff[birth] += 1;
            diff[death] -= 1;
        }

        int currentPopulation = 0;
        int maxPopulation = 0;
        int earliestYear = 1950;

        for(int year = 1950; year <= 2050; year++){
            currentPopulation += diff[year];

            if(currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                earliestYear = year;
            }
        }

        return earliestYear;
    }
}