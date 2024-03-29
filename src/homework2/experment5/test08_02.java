package picture;

import java.lang.*;
import java.util.*;
import java.util.Scanner;

class Node{
    int x,y;
    int px,py;
    int ans;
}
public class test08_02  {
    static int MAXN = 10;
    static int n,m;
    static int[][] mat = new int[MAXN][MAXN];
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static Node st;
    static void Copy(Node a,Node b){
        a.x = b.x;
        a.y = b.y;
        a.px = b.px;
        a.py = b.py;
        a.ans = b.ans;
    }
    static boolean check(int x,int y){
        if(x < 1 || x > n || y < 1 || y > m || mat[x][y] == 1)
            return false;
        else
            return true;
    }
    static boolean bfs_person(Node a,Node c){
        Queue<Node> qu = new LinkedList<Node>();
        int[][] visited = new int[MAXN][MAXN];
        Node next;
        Node b = new Node();
        b.x = a.px;b.y = a.py;
        qu.offer(b);
        visited[b.x][b.y] = 1;
        while (!qu.isEmpty()){
            Node now = qu.poll();
            if(now.x == a.x && now.y == a.y)
                return true;
            for(int i = 0; i < 4; i++){
                next = new Node();
                Copy(next,now);
                next.x += dir[i][0];
                next.y += dir[i][1];
                if(!check(next.x, next.y) || (next.x == c.x && next.y == c.y))
                    continue;
                if(visited[next.x][next.y] == 1)
                    continue;
                visited[next.x][next.y] = 1;
                qu.offer(next);
            }
        }
        return false;
    }
    static int bfs_box(){
        Queue<Node> qu = new LinkedList<Node>();
        Node next;
        Node pre;
        int[][][] visited = new int[MAXN][MAXN][4];
        st.ans = 0;
        qu.offer(st);
        while (!qu.isEmpty()){
            Node now = qu.poll();
            if(mat[now.x][now.y] == 3)
                return now.ans;
            for(int i = 0; i < 4; i++){
                next = new Node();
                Copy(next,now);
                next.x += dir[i][0];
                next.y += dir[i][1];
                if(!check(next.x, next.y) || visited[next.x][next.y][i] == 1)
                    continue;
                pre = new Node();
                Copy(pre,now);
                if(i == 0) pre.x = pre.x + 1;
                else if (i == 1) pre.x = pre.x - 1;
                else if (i == 2) pre.y = pre.y + 1;
                else if (i == 3) pre.y = pre.y - 1;
                if(!check(pre.px, pre.py))
                    continue;
                else if (!bfs_person(pre, now))
                        continue;
                visited[next.x][next.y][i] = 1;
                next.px = now.x;next.py = now.y;
                next.ans = now.ans + 1;
                qu.offer(next);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T;
        T = input.nextInt();
        while (T --> 0){
            st = new Node();
            n = input.nextInt();
            m = input.nextInt();
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= m; j++)
                    mat[i][j] = input.nextInt();
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= m; j++){
                    if(mat[i][j] == 4){
                        st.px = i;
                        st.py = j;
                    }
                    else if(mat[i][j] == 2){
                        st.x = i;
                        st.y = j;
                    }
                }
            System.out.println(bfs_box());
        }
    }
}
