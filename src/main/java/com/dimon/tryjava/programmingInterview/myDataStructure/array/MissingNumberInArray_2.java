package com.dimon.tryjava.programmingInterview.myDataStructure.array;

public class MissingNumberInArray_2 {


   /*

    This was an Amazon interview question ....
    Solution for that it was ....
            1) Calculate the sum of all numbers stored in the array of size 51.
            2) Subtract the sum from (52 * 53)/2 ---- Formula : n * (n + 1) / 2.

    but anyways I have also come up with the approach that uses XOR..

    We can use XOR operation which is safer than summation because in programming languages if the given input is large it may overflow and may give wrong answer.

    Before going to the solution A xor A = 0 so if we xor two identical number the value is Zero.

// Assuming that the array contains 99 distinct integers between 1..99 and empty slot value is zero
for(int i=0;i<100;i++)
    {
        if(ARRAY[i] != 0)
            XOR ^= ARRAY[i];
        XOR ^= (i + 1);
    }
return XOR;



*/

}
