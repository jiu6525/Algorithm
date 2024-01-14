package 벨만포드;


//벨만포드의 최단 경로 알고리즘 구현
//연결되고, 가중치가 있는 그래프를 나타내느 클래스
public class BellmanFordGraph {
//그래프의 가중치를 나타내는 클래스
class Edge{
int src, dest, weight;
Edge(){
src = dest = weight = 0;
}
};
int V, E;
Edge edge[];
//V, E가 있는 그래프 생성
BellmanFordGraph(int v, int e) {
//TODO Auto-generated constructor stub
V = v;
E = e;
edge = new Edge[e];
for(int i=0; i<e; ++i) {
edge[i] = new Edge();
}
}
//벨만포드 알고리즘을 이용하여 src에서 다른 정점들까지의 최단거리를 찾는 메인 기능
//음의 무게 주기 감지
void BellmanFord(BellmanFordGraph graph, int src) {
int V = graph.V, E = graph.E;
int dist[] = new int[V];
//1단계 : src에서 다른 정점으로 모든 정점 초기화
for(int i=0; i<V; ++i) {
dist[i] = Integer.MAX_VALUE;
}
dist[src] = 0;
//2단계 : 모든 edge|V|-1회,
//src에서 다른 정점들까지의 간단한 최단경로는 |V|-1 선을 가질 수 있다.
for(int i=1; i<V; ++i) {
for(int j=0; j<E; ++j) {
int u = graph.edge[j].src;
int v = graph.edge[j].dest;
int weight = graph.edge[j].weight;
if(dist[u] != Integer.MAX_VALUE && dist[u]+weight< dist[v]) {
dist[v] = dist[u]+weight;
}
}
}
//3단계 : 비 가중치 사이클 점검
//만약 더 짧은 길을 가진다면 순환이 이루어진다
for(int j=0; j<E; ++j) {
int u = graph.edge[j].src;
int v = graph.edge[j].dest;
int weight = graph.edge[j].weight;
if(dist[u] != Integer.MAX_VALUE && dist[u]+weight < dist[v]) {
System.out.println("Bellman-Ford Graph contains negative weight cycle");
}
}
printArr(dist, V);
}
//배열 출력
void printArr(int dist[], int V) {
System.out.println("Vertex Distance from Source");
for(int i=0; i<V; ++i) {
System.out.println(i+"\t\t"+dist[i]);
}
}
public static void main(String[] args) {
//TODO Auto-generated method stub
int V = 6; // 그래프의 점의 수
int E = 20; // 그래프의 선의 수
BellmanFordGraph graph = new BellmanFordGraph(V, E);
//add edge 0-1
graph.edge[0].src = 0;
graph.edge[0].dest = 1;
graph.edge[0].weight = 2;
//add edge 0-2
graph.edge[1].src = 0;
graph.edge[1].dest = 2;
graph.edge[1].weight = 5;
//add edge 1-2
graph.edge[2].src = 0;
graph.edge[2].dest = 3;
graph.edge[2].weight = 1;
//add edge 1-3
graph.edge[3].src = 1;
graph.edge[3].dest = 0;
graph.edge[3].weight = 3;
//add edge 1-4
graph.edge[4].src = 1;
graph.edge[4].dest = 2;
graph.edge[4].weight = 3;
//add edge 3-2
graph.edge[5].src = 1;
graph.edge[5].dest = 3;
graph.edge[5].weight = 2;
//add edge 3-1
graph.edge[6].src = 2;
graph.edge[6].dest = 0;
graph.edge[6].weight = 8;
//add edge 4-3
graph.edge[7].src =2;
graph.edge[7].dest = 1;
graph.edge[7].weight = 6;

graph.edge[8].src = 2;
graph.edge[8].dest = 3;
graph.edge[8].weight = 3;

graph.edge[9].src = 3;
graph.edge[9].dest = 0;
graph.edge[9].weight = 7;

graph.edge[10].src = 3;
graph.edge[10].dest = 1;
graph.edge[10].weight = 2;

graph.edge[11].src = 3;
graph.edge[11].dest = 2;
graph.edge[11].weight = 3;

graph.edge[12].src = 3;
graph.edge[12].dest = 4;
graph.edge[12].weight =1;

graph.edge[13].src = 4;
graph.edge[13].dest = 2;
graph.edge[13].weight = 1;

graph.edge[14].src = 4;
graph.edge[14].dest = 3;
graph.edge[14].weight = 1;

graph.edge[15].src = 4;
graph.edge[15].dest = 5;
graph.edge[15].weight = 2;

graph.edge[16].src = 5;
graph.edge[16].dest = 2;
graph.edge[16].weight = 8;

graph.edge[17].src = 5;
graph.edge[17].dest = 4;
graph.edge[17].weight =4;



graph.BellmanFord(graph, 0);
}
}

