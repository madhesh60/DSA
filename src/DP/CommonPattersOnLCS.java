package DP;

public class CommonPattersOnLCS {
    public static void main(String[] args) {

        /*
        Longest Palindromic Subsequence and Minimum Insertions to Make String Palindrome
        WE KEEP THE PALINDROME SEQ UNALTERED IN THE GIVEN STRING
        FOR THIS WE REVERSE THE GIVEN STRING AND TREAT AS S2
        WE COMPARE AND THEN GET IT

        //ANS=LongestSubseq(s,s.rev());

        THIS IS FOR MIN INSERTION TO MAKE IT PALINDROME [RETURN N-ANS]
        */


        /*
         Minimum Insertions or Deletions to Convert String A to String B
         SAME AS 1 - WE KEEP THE SAME CHAR SEQ UNALTERED IN THE GIVEN STRING1
         RETURN N-LEN(LCS) + M-LEN(LCS)
         */

        /*
        Shortest Common Subsequence
        SHORTEST STRING WE CAN MAKE FROM S1 AND S2 BY COMBINING THEM
        SO THAT WE CAN MAKE S1 ANS S2 FROM THE NEW STRING[CORRECT ORDER]

         SAME AS 1 - WE TAKE THE SAME CHAR SEQ AND WE ARE GONNA PUT IT ONCE
         RETURN N+M-LEN(LCS)
         */

    }
}
