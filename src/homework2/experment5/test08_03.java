package picture;

import java.util.*;
import java.lang.*;
import java.util.Scanner;

class Edge{
    int u;
    int v;
    int w;
    public Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}
public class test08_03 {
    final static int MAXV=55;
    final static int MAXE=3000;
    static int[] parent=new int[MAXV];
    static int[] rank=new int[MAXV];
    static int n,m;
    static Edge[] E;
    static int ans;
    public static void Init(){
        for (int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public static int Find(int x){
        if (x!=parent[x])
            parent[x]=Find(parent[x]);
        return parent[x];
    }
    public static void Union(int x,int y){
        int rx=Find(x);
        int ry=Find(y);
        if (rx==ry)
            return;
        if (rank[rx]<rank[ry])
            parent[rx]=ry;
        else {
            if (rank[rx]==rank[ry])
                rank[rx]++;
            parent[ry]=rx;
        }
    }
    public static void Kruskal(){
        ans=0;
        Arrays.sort(E, 0, m, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });
        Init();
        int cnt=1;
        int j=0;
        while (cnt<n){
            int u1=E[j].u;int v1=E[j].v;
            int sn1=Find(u1);
            int sn2=Find(v1);
            if (sn1!=sn2){
                ans+=E[j].w;
                cnt++;
                Union(u1,v1);
            }
            j++;
        }
    }
    public static void main(String[] args){
        Scanner fin=new Scanner(System.in);
        while (fin.hasNext()){
            E=new Edge[MAXV];
            n= fin.nextInt();
            if (n==0)
                break;
            m= fin.nextInt();
            for (int i=0;i<m;i++){
                int x,y,w;
                x= fin.nextInt();
                y= fin.nextInt();
                w= fin.nextInt();
                E[i]=new Edge(x,y,w);
            }
            Kruskal();
            System.out.println(ans);
        }
    }
}
