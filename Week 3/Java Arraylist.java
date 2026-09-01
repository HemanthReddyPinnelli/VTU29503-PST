import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static void main(String[] args) {
        try(var br = new BufferedReader(new InputStreamReader(System.in));
            var bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            List<List<String>> numbersList = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            while(n-- > 0){
                var line = br.readLine().split(" ");
                var size = Integer.parseInt(line[0]);
                var list = new ArrayList<String>(size);
                for (int i = 1; i <= size; i++) {
                    list.add(line[i]);
                }
                numbersList.add(list);
            }
            int q = Integer.parseInt(br.readLine());
            while(q-- > 0){
                var index = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                try{
                    var element = numbersList.get(index[0] - 1).get(index[1] - 1);  
                    bw.write(String.format("%s%n", element));  
                } catch (IndexOutOfBoundsException e) {
                    bw.write(String.format("ERROR!\n"));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
