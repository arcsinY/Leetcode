class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--)
        {
            digits[i]++;  //+1
            digits[i] = digits[i] % 10;  //进位，由于是+1，所以进位后这一位只能是0
            if (digits[i] != 0)  //不是0说明没有没有进位
                return digits;
        }
        digits = new int[digits.length + 1];  //多了一位，只能是999……+1。进位后第一位为1，后面为0
        digits[0] = 1;
        return digits;
    }
}