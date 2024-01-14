package ��������;


//���������� �ִ� ��� �˰��� ����
//����ǰ�, ����ġ�� �ִ� �׷����� ��Ÿ���� Ŭ����
public class BellmanFordGraph {
//�׷����� ����ġ�� ��Ÿ���� Ŭ����
class Edge{
int src, dest, weight;
Edge(){
src = dest = weight = 0;
}
};
int V, E;
Edge edge[];
//V, E�� �ִ� �׷��� ����
BellmanFordGraph(int v, int e) {
//TODO Auto-generated constructor stub
V = v;
E = e;
edge = new Edge[e];
for(int i=0; i<e; ++i) {
edge[i] = new Edge();
}
}
//�������� �˰����� �̿��Ͽ� src���� �ٸ� ����������� �ִܰŸ��� ã�� ���� ���
//���� ���� �ֱ� ����
void BellmanFord(BellmanFordGraph graph, int src) {
int V = graph.V, E = graph.E;
int dist[] = new int[V];
//1�ܰ� : src���� �ٸ� �������� ��� ���� �ʱ�ȭ
for(int i=0; i<V; ++i) {
dist[i] = Integer.MAX_VALUE;
}
dist[src] = 0;
//2�ܰ� : ��� edge|V|-1ȸ,
//src���� �ٸ� ����������� ������ �ִܰ�δ� |V|-1 ���� ���� �� �ִ�.
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
//3�ܰ� : �� ����ġ ����Ŭ ����
//���� �� ª�� ���� �����ٸ� ��ȯ�� �̷������
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
//�迭 ���
void printArr(int dist[], int V) {
System.out.println("Vertex Distance from Source");
for(int i=0; i<V; ++i) {
System.out.println(i+"\t\t"+dist[i]);
}
}
public static void main(String[] args) {
//TODO Auto-generated method stub
int V = 6; // �׷����� ���� ��
int E = 20; // �׷����� ���� ��
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

