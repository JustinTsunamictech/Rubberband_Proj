
import java.util.*;

public class PegBand
{
    public static void main(String[] args)
    {
        Graph thisGraph = new Graph();
        int[] positionArray = new int[thisGraph.adjacencyList.length];

        for(int i = 0; i < thisGraph.adjacencyList[].length; i++)
            positionArray[i] = i;

        int originalCost = calculateCost(positionArray, thisGraph.adjacencyList);
        compareCost(pairCompare(positionArray, thisGraph.adjacencyList), originalCost);
        
    }
    //Calculate and return the total cost of the arrangement of posts.
    public int calculateCost(int[] position, int[][] adjacencyList)
    {
        //The cost of the permutation in its entirety.
        int totalCost = 0;

        //Traverse the entire adjacency list to identify each pair of pegs bounded by a band.
        for(int i = 0; i < adjacencyList.length; i++)
        {
            for(int j = 0; j < adjacencyList[i].length; j++)
            {
                //Store both pegs in the pair.
                int firstPeg = adjacencyList[i];
                int secondPeg = adjacencyList[i][j];

                //Compare the positions of the pegs. Add the difference between them to the cost 
                //of the permutation.
                if(position[firstPeg] > position[secondPeg])
                    totalCost += (position[firstPeg] - position[secondPeg]);
                else
                    totalCost += (position[secondPeg] - position[firstPeg]);
            } 
        }   
        return totalCost;
     }
 //Return the post with the highest connection count.
 public int getHighestCon(int[] position, int[][] adjacencyList)
 {
        //Tracks number of connections for each post in position array.
        int[] connectionCount = new int[position.length];
         
        //Add the number of connections for each post to the connectionCount array.
        for(int i = 0; i < adjacencyList.length; i++)
        {
            for(int j = 0; j < adjacencyList[i].length; j++)
            {
                connectionCount[i] += adjacencyList[i].length;
                connectionCount[adjacenyList[i][j]]++;
            }
        }

        //Stores the highest connection count.
        int highestConCount = 0;
        //Stores post # with highest number of connections.
        int post = 0;

        //Find the post with the highest connection count and save it.
        for(int i = 0; i < connectionCount.length; i++)
        {
            if(connectionCount[i] > highestConCount)
                highestConCount = i;
        }
     
        return highestConCount;
     
        //Stores the highest connection count.
        int highestConCount = 0;

        for(int i = 0; i < connectionCount.length; i++)
        {
            if(connectionCount[i] > highestConCount)
                highestConCount = i;
        }
    
        return highestConCount;
 }
     public int[] pairImprover(int[] position, int[][] adjacency)
     {
        //Stores # of connections between each post number and a specific post;
         int[] pairCompare = new int[position.length];
         //Find # connections between every post and given post h.
         //Put the highest connection pairs next to one another in the position array.
         //Do same process for every post.
         for(int h = 0; h < adjacency.length - 1; h++)
         {
             for(int i = 0; i < adjacency.length; i++)
             {
                 for(int j = 0; j < adjacency[i].length; j++)
                 {
                      pairCompare[adjacency[h][j]]++;
                      if(adjacency[i][j] == h)
                          pairCompare[i]++;
                      
                 }
             }
             int largestPairCount  = 0;
             for(int k = 0; k < pairCompare.length; k++)
             {
                 if(pairCompare[k] > largestPairCount)
                     largestPairCount = k;
             }
             int temp = position[h + 1];
             position[h + 1] = k;
             position[k] = temp;
         }
         return position;
     }

     public void compareCost(int origCost, int newCost)
     {
        System.out.print(newCost - origCost); 
     }
}
