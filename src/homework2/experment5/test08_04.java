package picture;

import java.util.*;
import java.lang.*;

public class test08_04 {
    static final int INF=0x3f3f3f3f;
    static final int MAXV=1001;
    static int[][] mat=new int[MAXV][MAXV];
    static int V;
    static int[] dist=new int[MAXV];
    static int[] S=new int[MAXV];
    static void Dijkstra(int[] link,int n){
        Arrays.fill(S,0);
        for (int i=1;i<=V;i++){
            dist[i]=INF;
            S[i]=0;
        }
        for (int i=1;i<=n;i++)
            dist[link[i]]=0;
        while (true){
            int u=-1;
            for (int i=1;i<=V;i++){
                if (S[i]==0 && (u==-1 ||dist[u]>dist[i]))
                    u=i;
            }
            if (u==-1)
                break;
            S[u]=1;
            for (int j=1;j<=V;j++){
                if (dist[j]>dist[u]+mat[u][j])
                    dist[j]=dist[u]+mat[u][j];
            }
        }
    }
    public static void main(String[] args){
        Scanner fin=new Scanner(System.in);
        int T,S,D;
        while (fin.hasNext()){
            T= fin.nextInt();
            S= fin.nextInt();
            D= fin.nextInt();
            V=0;
            for (int i=1;i<MAXV;i++)
                for (int j=1;j<MAXV;j++)
                    mat[i][j]=(i==j?0:INF);
            for (int i=1;i<=T;i++){
                int a,b,time;
                a= fin.nextInt();
                b= fin.nextInt();
                time=fin.nextInt();
                V=Math.max(V,Math.max(a,b));
                if (mat[a][b]>time)
                    mat[a][b]=mat[b][a]=time;
            }
            int[] link=new int[MAXV];
            int[] want=new int[MAXV];
            for (int i=1;i<=S;i++)
                link[i]= fin.nextInt();
            for (int i=1;i<=D;i++)
                want[i]= fin.nextInt();
            Dijkstra(link,S);
            int ans=INF;
            for (int i=1;i<=D;i++)
                ans=Math.min(ans,dist[want[i]]);
            System.out.println(ans);
        }
    }
}
