import edu.princeton.cs.algs4.*;

public class NutBoltMatch {

  public static void match(Nut[] a, Bolt[] b) {
    findSame(a, b, 0, a.length-1);


  }
  private static void findSame(Nut[] a, Bolt[] b, int begin, int end){
    if(end <= begin){
      return;
    }
    int switche = splitNuts(a, begin, end, b[end]);
    splitBolts(b, begin, end, a[switche]);
    findSame(a, b, begin, switche - 1);
    findSame(a, b, switche + 1, end);

  }

  //Sér um Nuts
  private static int splitNuts(Nut[] a,int begin, int end, Bolt b){
    int j = begin;

    for(int i = begin; i < end; i++){
      if(a[i].compareTo(b) > 0){
        switchNuts(a, j, i);
        j++;
      }else if(a[i].compareTo(b) == 0){
        switchNuts(a, j, end);
        i--;
      }
    }
    switchNuts(a, j , end);
    return j;
  }
  private static void switchNuts(Nut[] a, int j, int i){
    Nut temp = a[j];
    a[i] = a[j];
    a[j] = temp;
  }

  //Sér um Bolts
  private static int splitBolts(Bolt[] b,int begin, int end, Nut a){
    int j = begin;

    for(int i = begin; i < end; i++){
      if(a.compareTo(b[i]) < 0){
        switchBolts(b, j, i);
        j++;
      }else if(a.compareTo(b[i]) == 0){
        switchBolts(b, j, end);
        i--;
      }
    }
    switchBolts(b, j , end);
    return j;
  }
  private static void switchBolts(Bolt[] b, int j, int i){
    Bolt temp = b[j];
    b[i] = b[j];
    b[j] = temp;
  }



/*

  private static String testNut(Nut[] a){
    String nutt = "";
    for (Nut b : a) {
      nutt += b.value + " ";
    }
    return nutt;
  }
  private static String testBolt(Bolt[] b){
    String boltt = "";
    for (Bolt e: b) {
      boltt += e.value + " ";
    }
    return boltt;
  }

  public static void main(String[] args) {
    Nut a[] = {new Nut(1), new Nut(2), new Nut(3), new Nut(4),
    new Nut(5), new Nut(6), new Nut(7), new Nut(8), new Nut(9)};

    Bolt b[] = {new Bolt(9), new Bolt(8), new Bolt(7), new Bolt(6),
    new Bolt(5), new Bolt(4), new Bolt(3), new Bolt(2), new Bolt(1)};

    StdOut.println(testNut(a));
    StdOut.println(testBolt(b));

    match(a,b);

    StdOut.println(testNut(a));
    StdOut.println(testBolt(b));
  }
*/
}
