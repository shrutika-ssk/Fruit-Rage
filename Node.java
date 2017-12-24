public class Node {

 int[][] board;
 int player=0;
 Node parent;
 int score = 0;
 int depth = 0;
 int n;
 double alpha=Double.NEGATIVE_INFINITY;
 double beta=Double.POSITIVE_INFINITY;
 
 public Node(int[][] sol, int n){
 board = new int[n][n] ;
 board=sol;
 parent = null;
 double alpha=Double.NEGATIVE_INFINITY;
 double beta=Double.POSITIVE_INFINITY;
 }
 
 public Node(int[][] board, int n, Node parent, int score, int depth, int player, double alpha, double beta){
 this.board = board;
 this.n=n; 
 this.parent = parent;
 this.score = score;
 this.depth = depth;
 this.player = player;
 this.alpha = alpha;
 this.beta = beta;
 }
}