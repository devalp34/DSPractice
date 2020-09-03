import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'autocomplete' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY command as parameter.
     */
    class Node
     {
         HashMap<Integer,Node> hm;
         HashMap<Node,Integer> lathm;

         public Node()
         {
             hm = new HashMap<>();
             lathm = new HashMap<>();
         }
     }

    public static List<Integer> autocomplete(List<String> command) {
    // Write your code here
        Node node = new Node();
        Node ptr, head;

        ptr = head = node;
        String s = command.get(0);

        List<Integer> ans = new LinkedList<>();
        int temp = 0;
        for(char c : s.toCharArray())
        {
            temp = Character.getNumericValue(c);
            Node node1 = new Node();
            ptr.hm.put(temp, node1);
            ptr.lathm.put(node1,1);
            ptr = node;
        }

        ans.add(0);
        int nVal = 0, lastVal = 0, size = command.size();

        for(int i = 1 ; i < size ; i++)
        {
            s = command.get(i);
            ptr = head;
            lastVal = 0;
            
            for(char c : s.toCharArray())
            {
                nVal = Character.getNumericValue(c);
                if(ptr.hm.containsKey(nVal))
                {
                    Node tempNode = ptr.hm.get(nVal);
                    lastVal = ptr.lathm.get(tempNode);
                    ptr = tempNode;
                }
                else
                {
                    if(lastVal == 0) lastVal = i;
                    Node tempNode1 = new Node();
                    ptr.hm.put(nVal,tempNode1);
                    ptr.lathm.put(tempNode1,i+1);
                    ptr = tempNode1;
                }
            }
            ans.add(lastVal);
        }
        return ans;
    }
}

public class Solution {
