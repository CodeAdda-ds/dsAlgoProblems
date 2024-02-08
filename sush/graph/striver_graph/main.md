![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/8b4e8d98-f132-491a-a54b-76779fa427bc)

![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/4951e1b0-2719-4452-89ad-1b76d1533f6a)
these are also graphs, they don't necessarily need to be enclosed

Cycles in a graph
- starts from a node and ends at the same node
- there can be multiple cycles in a graph
- if there is at least a single cycle, it can be called undirected cyclic graph(first pic has 3 cycles, hence it is cyclic)

DAG: Directed Acyclic Graph
![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/eaabce8f-05f3-42aa-b6d7-b3717b720317)


Path:
![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/fa99012e-f21b-4f50-a85b-91a4e025d65a)

- can contain a lot of nodes/vertices and each of them are reachable
- a node cannot appear twice in a path ( 1 2 3 2 1 is not a path)
- adjacent nodes must have an edge between them

Degree: 
- no of edges that go inside/outside that node 
- Deg(undirected graph): the no of edges that are attached to it(node ki degree batayi jati hai)
- Total degree of graph = 2 * no of edges

Directed Graph:
  - Indegree(node): no of edges going inside that node
  - Outdegree(node): no of edges going outside from that node

<img width="797" alt="image" src="https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/f5617610-e0a8-4b2b-8289-48dfee7091e0">

Edge weight: weight of edge (self explanatory)

<br>
Representing graph:
they'll always give n -> nodes and m -> edges
then m lines -> represent edges (edges in no specific order)

![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/d25388f7-514f-45a6-b19c-cda2fc95e5f2)

Now, how do we store?

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no of nodes:");
        int n = scanner.nextInt();
        System.out.println("Enter the no of lines representing edges:");
        int m = scanner.nextInt();

        int[][] adjMat = new int[n + 1][n + 1];
        ArrayList<Pair>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }


        for (int i = 1; i <= m; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int wt = scanner.nextInt();

            adjMat[v1][v2] = wt;
            adjMat[v2][v1] = wt; // remove this line for directed graph

            adjList[v1].add(new Pair(v2, wt));
            adjList[v2].add(new Pair(v1, wt)); // remove this line for directed graph
        }

        // ---------ADJACENCY MATRIX-------------------//

        // space complexity for undirected graph= O(V*V)
        // space complexity for directed graph : O(V*V)

        System.out.println("\nADJACENCY MATRIX REPRESENTATION : ");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n*******************************************************************************\n");

        // ---------ADJACENCY LIST-------------------//

        // space complexity for undirected graph= O(2E)
        // space complexity for directed graph : O(E)

        System.out.println("\nADJACENCY LIST REPRESENTATION :");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (Pair pair : adjList[i]) {
                System.out.print("(" + pair.connNode + "," + pair.weight + ") ");
            }
            System.out.println();
        }

        scanner.close();
    }

    static class Pair {
        int connNode;
        int weight;

        Pair(int connNode, int weight) {
            this.connNode = connNode;
            this.weight = weight;
        }
    }
}

```
Connected components: 
this is also a graph which has been broken down into 4 components
![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/a11b5556-f950-44ff-ad46-ae1c87b3ce7d)
Whenever we do traversal, we will always make use of a visited array
(use this general snippet)
![image](https://github.com/CodeAdda-ds/dsAlgoProblems/assets/47095559/2cd04c05-c90f-495b-b7da-11aceae6fca8)


