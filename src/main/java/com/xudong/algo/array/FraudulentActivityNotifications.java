package com.xudong.algo.array;

import java.util.Arrays;

public class FraudulentActivityNotifications {
    public int countNotification(int[] expenditures, int d) {
        int start = d;
        int notification = 0;
        while (start <= expenditures.length - 1){
            int threshold = findThreshold(expenditures, start, d);
            if(threshold <= expenditures[start]) notification ++;
            start++;
        }
        return notification;
    }

    private int findThreshold(int[] expenditures, int start, int d) {
        if(start-d == 0) Arrays.sort(expenditures, start-d, start);
        else{
            selectionSort(expenditures, start-d, start-1);
        }
        int middle = (start-1 + start-d) / 2;
        if(d%2 == 0){ // is even
            return expenditures[middle] + expenditures[middle+1];
        }else{
            return expenditures[middle] * 2;
        }
    }

    private void selectionSort(int[] arr, int start, int end) {
        while(start < end && arr[start] <= arr[end]) start++;
        int temp = arr[end];
        while(end > start){
            arr[end] = arr[end-1];
            end --;
        }
        arr[start] = temp;
    }
}
