//package homework2.experment3.recursion;
//
//public class huanghou {
//    public static void main(String[] args) {
//        System.out.println(process1(1,8));
//    }
//    public static int process1(int i,int n,int[] record){
//        if(i==n){//当i等于n时，说明N个皇后全部摆放完毕，此时应返回一种解法
//            return 1;
//        }
//        int res=0;
//        //现在轮到摆第i个皇后，
//        //通过遍历第i行的每一列试探每一个位置是否能放皇后
//        for(int j=0;j<n;j++){
//            if(isValid(record,i,j)){//通过isValid函数来判断这个位置是否能放皇后
//                record[i]=j;
//                res+=process1(i+1,n,record);
//            }
//        }
//        return  res;
//    }
//    public static boolean isValid(int[] record,int i,int j){
//        //判断逻辑：如果这个位置与之前的i-1个皇后同列或者共斜线则不能放皇后
//        for(int k=0;k<i;k++){
//            //判断共列以及共斜线
//            if(record[k]==j||(Math.abs(k-i)==Math.abs(record[k]-j))){
//                return false;
//            }
//        }
//        return true;
//    }
//}
