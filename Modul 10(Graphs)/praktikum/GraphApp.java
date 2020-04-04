/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_10.fix;

/**
 *
 * @author BintangDiLangit
 */
public class GraphApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        
//        theGraph.addVertex('A'); // 0
//        theGraph.addVertex('B'); // 1
//        theGraph.addVertex('C'); // 2
//        theGraph.addVertex('D'); // 3
//        theGraph.addVertex('E'); // 4
//        
//        theGraph.addEdge(0, 2); // AC
//        theGraph.addEdge(1, 0); // BA
//        theGraph.addEdge(1, 4); // BE
//        theGraph.addEdge(3, 4); // DE
//        theGraph.addEdge(4, 2); // EC
//        theGraph.display();
//        
//        theGraph.dfs();
//        theGraph.bfs();
//        theGraph.mst();
//        theGraph.connectivityTableDirect();
//        theGraph.connectivityTableDirect2same();
        
          theGraph.addVertex('A'); // 0
          theGraph.addVertex('B'); // 1
          theGraph.addVertex('C'); // 2
          theGraph.addVertex('D'); // 3
          theGraph.addVertex('E'); // 4
          theGraph.addVertex('F'); // 5
          theGraph.addVertex('G'); // 6
          theGraph.addVertex('H'); // 7
          
          
          theGraph.addEdge(0, 3); // AD
          theGraph.addEdge(0, 4); // AE
          theGraph.addEdge(1, 4); // BE
          theGraph.addEdge(3, 6); // DG
          theGraph.addEdge(4, 6); // EG
          theGraph.addEdge(6, 7); // GH
          theGraph.addEdge(2, 5); // CF
          theGraph.addEdge(5, 7); // FH
          
          theGraph.topo();
    }
}
