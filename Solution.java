// check if the current word can be added to 
// current row
// totalCharCount += length of current word
// width-totalLength = white space
// space between each word will be white space/count-1
// extra space will be white space % count-1
// extra space give space to each string starting from the left
// and then join the string using the space
import java.util.*;
public class Solution {

    private static String getSpace(int n)
    {
        return " ".repeat(Math.max(0, n));
    }
    private static String getRow(List<String> row,int len,int maxWidth)
    {
        if(row.isEmpty())
            return "";
        int space = maxWidth-len;
        int divisor = row.size()-1;
        if(divisor == 0)
        {
            return row.get(0) + getSpace(space);
        }
        else{
            int quot = space/divisor;
            int rem = space % divisor;
            for(int i=0;i<rem;i++)
            {
                row.set(i,row.get(i)+" ");
            }
            String delimiter = getSpace(quot);
            return String.join(delimiter,row);
        }
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {

        int totalLength = 0;
        List<String> row = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(String word:words)
        {
            if(word.length()+totalLength+row.size()<=maxWidth)
            {
                totalLength+=word.length();
                row.add(word);
            }
            else
            {
                ans.add(getRow(row,totalLength,maxWidth));
                totalLength = word.length();
                row = new ArrayList<>();
                row.add(word);
            }
        }

        ans.add(getRow(row,totalLength,maxWidth));
        return ans;

    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};

        // Convert to ArrayList
        System.out.println(fullJustify(words,16));
    }
}