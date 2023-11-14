package com.zsi;
import java.util.Arrays; 

public class Candy {
    public int candy(int[] ratings) {

        int[] output = new int[ratings.length];
        Arrays.fill(output, 1);

        Boolean changed = null;
        do 
        {
            changed = false;
            for (int i = 0; i < ratings.length; i++)
            {
                if (i == 0) 
                {
                    if (ratings[i] > ratings[i + 1]) 
                    {
                        output[i] = 2;
                    }
                }
                else if (i == ratings.length - 1)
                {
                    if (ratings[i] > ratings[i - 1])
                    {
                        output[i] = 2;
                    }
                }
                else {
                    if (ratings[i - 1] < ratings[i] && ratings[i] > ratings[i + 1])
                    {
                        int before = output[i];
                        int after = Math.max(output[i - 1], output[i + 1]) + 1;

                        if (before != after) 
                        {
                            output[i] = after;
                            changed = true;
                        }
                    }
                    else if ((ratings[i] < ratings[i + 1] && ratings[i] > ratings[i - 1])
                        || (ratings[i] > ratings[i + 1] && ratings[i] < ratings[i - 1]))
                    {
                        int before = output[i];
                        int after = Math.min(output[i - 1], output[i + 1]) + 1;

                        if (before != after) 
                        {
                            output[i] = after;
                            changed = true;
                        }
                    }
                    else if (ratings[i - 1] < ratings[i] && ratings[i] == ratings[i + 1])
                    {
                        if (output[i] != output[i - 1] + 1)
                        {
                            output[i] = output[i - 1] + 1;
                            changed = true;
                        }   
                    }
                    else if (ratings[i + 1] < ratings[i] && ratings[i] == ratings[i - 1])
                    {
                        if (output[i] != output[i + 1] + 1)
                        {
                            output[i] = output[i + 1] + 1;
                            changed = true;
                        }
                    }
                }
            }
        } while (changed);    
        
        int sum = 0;
        for (int i = 0; i < output.length; i++) 
        {
            sum = sum + output[i];
        }

        return sum;
    }
}