class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int operations = 0;
        while (true) {
            if (isNonDecreasing(list)) return operations;
            if (list.size() == 1) return operations;
            int minSum = list.get(0) + list.get(1);
            int minIndex = 0;
            for (int i = 1; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }            
            int mergedValue = list.get(minIndex) + list.get(minIndex + 1);
            list.set(minIndex, mergedValue);
            list.remove(minIndex+1);
            operations++;
        }
    }
    
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i=1; i < list.size(); i++) {
            if (list.get(i-1) > list.get(i)) return false;
        }
        return true;
    }
}