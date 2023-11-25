/*Find if it is possible to reach from sx,sy to point tx,ty.
* The allowed operation on some point (x, y) is to convert it to either (x, x + y) or (x + y, y).*/

public class ReachingPoint {
    public static void main(String[] args) {
        System.out.println(reachingPoints(1,1,3,5));
    }
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>=sx && ty>=sy){
            if(tx>ty){
                if(sy == ty) return (tx - sx) % ty == 0;
                tx = tx%ty;
            }else{
                if(sx == tx) return (ty - sy) % tx == 0;
                ty = ty%tx;
            }
        }
        return false;
    }
}
