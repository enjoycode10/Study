package com.test;

/**
 * @author Shawn
 * @date 2020/5/2 23:00
 * @title Function
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 测试用main方法
 *
 * @author wuhui.wwh
 */
public class TestGraph {
    public static void main(String[] args) {
        Graph.Vertex v1 = new Graph.Vertex("v1");
        Graph.Vertex v2 = new Graph.Vertex("v2");
        Graph.Vertex v3 = new Graph.Vertex("v3");
        Graph.Vertex v4 = new Graph.Vertex("v4");
        Graph.Vertex v5 = new Graph.Vertex("v5");
        Graph.Vertex v6 = new Graph.Vertex("v6");
        Graph.Vertex v7 = new Graph.Vertex("v7");
        Graph.Vertex v8 = new Graph.Vertex("v8");

        List<Graph.Vertex> verList = new LinkedList<Graph.Vertex>();
        verList.add(v1);
        verList.add(v2);
        verList.add(v3);
        verList.add(v4);
        verList.add(v5);
        verList.add(v6);
        verList.add(v7);
        verList.add(v8);

        Map<Graph.Vertex, List<Graph.Edge>> vertex_edgeList_map = new HashMap<>();

        List<Graph.Edge> v1List = new LinkedList<>();
        v1List.add(new Graph.Edge(v1, v2, 6));
        v1List.add(new Graph.Edge(v1, v4, 1));
        v1List.add(new Graph.Edge(v1, v4, 1));

        List<Graph.Edge> v2List = new LinkedList<Graph.Edge>();
        v2List.add(new Graph.Edge(v2, v3, 43));
        v2List.add(new Graph.Edge(v2, v4, 11));
        v2List.add(new Graph.Edge(v2, v5, 6));

        List<Graph.Edge> v3List = new LinkedList<Graph.Edge>();
        v3List.add(new Graph.Edge(v3, v8, 8));

        List<Graph.Edge> v4List = new LinkedList<Graph.Edge>();
        v4List.add(new Graph.Edge(v4, v3, 15));
        v4List.add(new Graph.Edge(v4, v5, 12));

        List<Graph.Edge> v5List = new LinkedList<Graph.Edge>();
        v5List.add(new Graph.Edge(v5, v3, 38));
        v5List.add(new Graph.Edge(v5, v8, 13));
        v5List.add(new Graph.Edge(v5, v7, 24));

        List<Graph.Edge> v6List = new LinkedList<Graph.Edge>();
        v6List.add(new Graph.Edge(v6, v5, 1));
        v6List.add(new Graph.Edge(v6, v7, 12));

        List<Graph.Edge> v7List = new LinkedList<Graph.Edge>();
        v7List.add(new Graph.Edge(v7, v8, 20));

        vertex_edgeList_map.put(v1, v1List);
        vertex_edgeList_map.put(v2, v2List);
        vertex_edgeList_map.put(v3, v3List);
        vertex_edgeList_map.put(v4, v4List);
        vertex_edgeList_map.put(v5, v5List);
        vertex_edgeList_map.put(v6, v6List);
        vertex_edgeList_map.put(v7, v7List);


        Graph g = new Graph(verList, vertex_edgeList_map);
        g.dijkstraTravasal(0, 7);
    }
}
