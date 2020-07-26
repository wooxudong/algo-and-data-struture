package com.xudong.algo.array;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * <p>
 * Note:
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 *
 * @author wooxudong
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int tank = 0, total = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if(tank < 0){
                tank = gas[i] - cost[i];
                start = i;
            }else{
                tank += gas[i] - cost[i];
            }
        }

        return total >= 0 ? start : -1;
    }
}
