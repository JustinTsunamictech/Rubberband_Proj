
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
        improverOne(positionArray, thisGraph.adjacencyList);
        compareCost(originalCost, thisGraph.calculateCost())
        
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
     } 

        //Stores the highest connection count.
        int highestConCount = 0;

        for(int i = 0; i < connectionCount.length; i++)
        {
            if(connectionCount[i] > highestConCount)
                highestConCount = i;
        }
    
        return highestConCount;
     } 

     public int compareCost(int origCost, int newCost)
     {
        return (newCost - origCost); 
     }
}
