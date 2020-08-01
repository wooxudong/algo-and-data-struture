package com.xudong.algo.array;

public class SockMerchant {
    int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        int[] colors = new int[101];

        for (int i=0; i< n; i++){
            if(colors[ar[i]] == 0) colors[ar[i]] +=1;
            else{
                colors[ar[i]] = 0;
                pairs += 1;
            }
        }
        return pairs;
    }
}
