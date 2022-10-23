/*
Алиса Селезнева была невероятно счастлива: она наконец запустила свой новый стартап по распознаванию увиденных облаков, который назвала строкой
A длины N. Но вдруг она узнала, что Зелибоба также запустил свой стартап по распознаванию облаков и назвал его строкой B длины N.
Алиса уверена, что Зелибоба сплагиатил её идею! Для начала она хочет вычислить метрику похожести названий их стартапов — если название будет похоже,
то ей будет сильно проще в дальнейших доказательствах и разбирательствах.
Более формально, пусть есть строки
A — название стартапа Алисы и строка
B — название стартапа Зелибобы. Обе строки имеют одинаковую длину N.
Для каждой позиции 1≤i≤N строки B, нужно вычислить тип совпадения в этой позиции со строкой A.
Если Bi=Ai, то в позиции i тип совпадения должен быть равен P (от слова plagiarism).
Если Bi≠Ai, но существует другая позиция 1≤j≤N, такая что Bi=Aj,
то в позиции i тип совпадения должен быть равен S (от слова suspicious).
В остальных позициях тип совпадения должен быть равен I (от слова innocent).
*/
import java.io.PrintWriter;
import java.util.*;

public class taskA {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        int len = B.length();
        char[] Aarr=A.toCharArray();
        char[] Barr=B.toCharArray();
        char[] Narr= new char[len];
        HashSet<Integer> mySet= new HashSet<>();
        HashMap<Character,Integer> myMap = new HashMap<>();
        for (int i=0;i<len;i++){
            if (Aarr[i]==Barr[i]){
                Narr[i]='P';
            } else {
                mySet.add(i);
                myMap.merge(Aarr[i], 1, Integer::sum);
            }
        }
        for (int i: mySet) {

            char myChar = Barr[i];
            Integer amount = myMap.get(myChar);
            if (amount != null){
            if (amount>0){
                Narr[i]= 'S';
                myMap.merge(myChar, 1, (v1, v2) -> v1 - v2);
            } else {
                Narr[i]= 'I';
            }} else {
                Narr[i]= 'I';
            }

        }

        PrintWriter writer = new PrintWriter(System.out);
        for (char c: Narr) {
            writer.write(c);
        }

        writer.flush();
        writer.close();
    }
}