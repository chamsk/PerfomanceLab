import java.util.ArrayList;

/**
 * Created by admin on 16.10.2018.
 */
public class FirstDay {


    public static void main(String args[]){
        FirstDay firstDay = new FirstDay();
        String s =  "2 3 3\n" +
                "1 2 4\n" +
                "3 1 5\n" +
                "c 2 1\n" +
                "r 1 2\n" +
                "g 1 3";
        firstDay.matrix(s);

    }
    //Реализовать ф-цию. Параметр weekday принимает true, если сейчас будний день иначе выходные. Параметр vacation говорит, что мы в отпуске.
    public boolean sleepIn(boolean weekday, boolean vacation){
        if(vacation){
            return true;
        }
        else if(!weekday){
            return true;
        }
        else return false;
    }

    //Реализовать ф-цию. Вернуть сумму чисел a и b, если они не равны. Иначе вернуть двойную сумму этих чисел.
    public int sumDouble(int a, int b){
        if(a==b){
            return (a+b)*2;
        }
        else return a+b;
    }

    //Реализовать ф-цию. Вернуть строку, которая состоит из пар индексов 0,1, 4,5, 8,9 и т.д.
    public String altPairs(String str){
        if(str==null) return null;
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<chars.length;i+=4){
            sb.append(chars[i]);
            sb.append(chars[i+1]);
        }
        return sb.toString();
    }

    //Реализовать метод, который принимает String в качестве аргумента. В аргемент будет передана "многострочная" строка. Напомню, что символ конца строки - '\n'.
    public void matrix(String str){
        String[] countLines = str.split("\n");
        String[] firstLine = countLines[0].split(" ");
        int n = Integer.parseInt(firstLine[0]);//кол-во строк матрицы
        int m = Integer.parseInt(firstLine[1]);//Кол-во столбцов матрицы
        int k = Integer.parseInt(firstLine[2]);//кол-во запросов

        int mass[][] = new int[n][m];
        //заполняем значениями матрицу
        for(int i = 0;i<n;i++){
            String[] lineI = countLines[i+1].split(" ");
            for(int j =0;j<m;j++){
               mass[i][j] = Integer.parseInt(lineI[j]);
            }
        }
        for(int i =0;i<k;i++){
            String[] line = countLines[i+n+1].split(" ");
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            switch (line[0]){
                case "g":
                    System.out.println(mass[a-1][b-1]);
                    break;
                case "c": //меняем столбцы
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for(int f = 0;f<n;f++){
                        arrayList.add(mass[f][a-1]);
                    }
                    for(int r=0;r<n;r++){
                        mass[r][a-1] = mass[r][b-1];
                        mass[r][b-1] = arrayList.get(r);
                }
                    break;
                case "r": //меняем строки
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for(int f = 0;f<m;f++){
                        arrayList2.add(mass[a-1][f]);
                    }
                    for(int r=0;r<m;r++){
                        mass[a-1][r] = mass[b-1][r];
                        mass[b-1][r] = arrayList2.get(r);
                    }
                    break;
            }
        }


    }


}
