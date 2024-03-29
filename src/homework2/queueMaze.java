package homework2;

import java.util.LinkedList;
import java.util.Queue;

public class queueMaze {
    public static void main(String[] args){
        int[][] maze ={{1,1,1,1,1,1},
                {1,0,1,0,0,1},
                {1,0,0,1,1,1},
                {1,0,1,0,0,1},
                {1,0,0,0,0,1},
                {1,1,1,1,1,1}};
        Result(maze,1,1,4,4);
    }
    public static boolean Result(int[][] maze, int startx,int starty,int endx,int endy){
        Queue<QueueNode> queue = new LinkedList<>();
        QueueNode startNode = new QueueNode(startx,starty);
        queue.offer(startNode);
        maze[starty][startx] = -1;
        QueueNode popNode = null;
        while(!queue.isEmpty()){
            popNode = queue.poll();
            if(popNode.x ==endx &&popNode.y == endy){
                showByEndNode(popNode);
                return true;
            }
            for (int i =0; i<4;i++){
                int insertx = 0;
                int inserty = 0;
                switch(i){
                    case 0:
                        insertx = popNode.x-1;
                        inserty = popNode.y;
                        break;
                    case 1 :
                        insertx = popNode.x+1;
                        inserty  = popNode.y;
                        break;
                    case 2 :
                         insertx = popNode.x;
                         inserty = popNode.y+1;
                         break;
                    case 3 :
                        insertx = popNode.x;
                        inserty = popNode.y-1;
                        break;
                }
                if (insertx>=0 && insertx< maze.length && inserty>=0 && inserty<maze.length &&maze[inserty][insertx] ==0){
                    maze[inserty][insertx] =-1;
                    QueueNode node =new QueueNode(insertx,inserty);
                    node.previous=  popNode;
                    queue.offer(node);
                }
            }
        }
        return false;
    }
    public static void showByEndNode(QueueNode endNode){
        while (endNode!=null) {
            System.out.println("["+endNode.y+","+ endNode.x+"]");
            endNode = endNode.previous;
}
    }
}
class QueueNode{
    int x;
    int y;
    QueueNode previous;
    public QueueNode(int x, int y) {
        this.x = x;
        this.y = y;
        this.previous = null;
    }
}