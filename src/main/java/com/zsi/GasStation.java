package com.zsi;
import java.util.Arrays; 

public class GasStation{
    public int canCompleteCircuit(int[] gas, int[] cost) {

        CacheNode[] cache = new CacheNode[gas.length];
        Arrays.fill(cache, null);


        for (int i = gas.length - 1; i >= 0; i--)
        {
            CacheNode atCacheI = new CacheNode();

            int j = i; int tank = 0;
            Integer totalGasSpent = null;
            while (true)
            {
                CacheNode ncache = cache[j];
                int travelCost = ncache == null ? cost[j] : ncache.gas;
                int nextStation = ncache == null ? j + 1: ncache.index; 
                tank = tank + gas[j];

                if (tank >= travelCost)
                {       
                    if (totalGasSpent == null)
                    {
                        totalGasSpent = 0;
                    }
                    
                    tank = tank - travelCost;

                    if (didWrapAround(i, j, gas))
                    {
                       
                        return i;
                    }

                    totalGasSpent = totalGasSpent + travelCost;
                    if (i != j)
                    {
                        totalGasSpent = totalGasSpent - gas[j];
                    }

                    j = nextStation;
                    if (j >= gas.length)
                    {
                        j = 0;
                    }
                }
                else 
                {
                    if (totalGasSpent != null) 
                    {
                        atCacheI.gas = totalGasSpent;
                        atCacheI.index = j;

                        cache[i] = atCacheI;
                    }
                    
                    break;
                }
            }

        }

        return -1;
    }

    private boolean didWrapAround(int i, int j, int[] gas)
    {
        boolean a = (j + 1) == i;
        boolean b = i == 0 && j == gas.length - 1;
        return a || b;
    }

    private static class CacheNode 
    {
        int index;
        int gas;
    }
}