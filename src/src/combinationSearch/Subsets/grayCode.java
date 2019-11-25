package combinationSearch.Subsets;

/***
 * Gray code: trong đó hai giá trị liên tiếp chỉ khác nhau một chữ số.
 */
public class grayCode {
    public static void grayCode(int num){
        int[] data = new int[num];
        enumerateInorder(data,0);
    }

    public static void enumerateInorder(int[] data, int start){
        if(start == data.length){
            for(int i = 0; i < data.length; i++) System.out.print(data[i] + " ");
            System.out.println();
            return;
        }
        enumerateInorder(data, start + 1);
        data[start] = 1 - data[start];
        enumerateInorder(data, start + 1);
    }
    public static void main(String[] args){
        grayCode(4);

    }
}
