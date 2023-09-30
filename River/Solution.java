import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static int calcSomme(long r){
        int somme = 0;
        while(r != 0){
            somme += r%10;
            r /= 10;
        }
        return somme;
    }

    private static List<Integer> generateSequence(int river) {
        List<Integer> nbs = new ArrayList<>();
        int i=0;
        nbs.add(river);
        while(i < 3000){
            river = river + calcSomme(river);
            nbs.add(river);
            i++;
        }
        return nbs;
    }

     private static <T> Set<T> findCommonElements(List<T> first, List<T> second) {
        return first.stream().filter(second::contains).collect(Collectors.toSet());
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();

        List<Integer> nbs = generateSequence((int)r1);
        List<Integer> nbs2 = generateSequence((int)r2);

       // Collections.sort(nbs);
       // Collections.sort(nbs2);

        System.err.println(nbs);
        System.err.println(nbs2);

         Set<Integer> common = findCommonElements(nbs, nbs2);
        System.out.println(Collections.min(common));
    }
}
