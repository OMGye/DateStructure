import java.math.BigDecimal;

/**
 * Created by upupgogogo on 2018/5/30.下午10:07
 */
public class Test {

    public static final int MIN = 30;

    public static double[] solution(double num, int size){
        double[] ret = new double[size];
        for (int i = size; i > 0; i --){
            if (i == 1){
                ret[i - 1] = num;
                break;
            }
             double res = num / i;
             res =  MIN + Math.random() * (res - MIN);
             num = num - res;
             ret[i - 1] = res;
        }
        return ret;
    }

    public static void main(String[] args) {
        double[] ret = solution(4000,100);
        double re = 0;
        for (int i = 0; i < ret.length; i++){
            System.out.println(ret[i]);
            re = ret[i] + re;
        }
        System.out.println(re);

    }
}
