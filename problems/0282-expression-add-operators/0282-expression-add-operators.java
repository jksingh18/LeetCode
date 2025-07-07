import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String num, int target, 
                    StringBuilder expression, int index, long currentValue, long lastOperand) {
        // Base case: if we reach the end of the string
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression.toString());
            }
            return;
        }

        // Iterate through all possible splits of the string
        for (int i = index; i < num.length(); i++) {
            // Extract the current number as a substring
            String currentStr = num.substring(index, i + 1);

            // Skip numbers with leading zeros
            if (currentStr.length() > 1 && currentStr.charAt(0) == '0') {
                continue;
            }

            // Convert the substring to a number
            long currentNum = Long.parseLong(currentStr);
            int lengthBefore = expression.length();

            // If this is the first number, add it directly to the expression
            if (index == 0) {
                expression.append(currentStr);
                backtrack(result, num, target, expression, i + 1, currentNum, currentNum);
                expression.setLength(lengthBefore); // Backtrack
            } else {
                // Add '+' operator
                expression.append("+").append(currentStr);
                backtrack(result, num, target, expression, i + 1, currentValue + currentNum, currentNum);
                expression.setLength(lengthBefore); // Backtrack

                // Add '-' operator
                expression.append("-").append(currentStr);
                backtrack(result, num, target, expression, i + 1, currentValue - currentNum, -currentNum);
                expression.setLength(lengthBefore); // Backtrack

                // Add '*' operator
                expression.append("*").append(currentStr);
                backtrack(result, num, target, expression, i + 1, 
                        currentValue - lastOperand + lastOperand * currentNum, lastOperand * currentNum);
                expression.setLength(lengthBefore); // Backtrack
            }
        }
    }
}