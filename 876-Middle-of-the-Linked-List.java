class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        return hand.length%groupSize==0;
    }
}