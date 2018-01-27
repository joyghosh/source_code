package algorithms.maths;

/**
 * Created by joyghosh on 07/01/18.
 */
public class ReplaceAll0 {

    public static void main(String[] args){
        int n = 1020;
        System.out.println(replace0To5(n));
    }

    //Replace all ‘0’ with ‘5’ in an input Integer
    public static int replace0To5Util(int x){
        if(x == 0) return 0;

        int lsd = x%10;
        if(lsd == 0){
            lsd = 5;
        }

        return replace0To5Util(x/10)*10 + lsd;
    }


    public static int replace0To5(int x){
        if(x==0) return 5;
        return replace0To5Util(x);
    }
}
