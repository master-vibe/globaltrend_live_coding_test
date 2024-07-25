public class Dijkstra {
    public void dijkstra(int[][] graph, int start){
        int n = graph.length;
        boolean[] visited_nodes = new boolean[n];
        int[] distance = new int[n];
        for(int i=0;i<n;i++){
            visited_nodes[i]=false;
            distance[i]=Integer.MAX_VALUE;
        }
        distance[start] = 0;
        for(int i=0;i<n;i++){
            //Updating neighbouring vertex distance
            int node = find_min_distance_node(distance,visited_nodes);
            visited_nodes[node]=true;
            //Updating all vertexes
            for(int j=0;j<n;j++){
                if(!visited_nodes[j] && graph[node][j]!=0 && distance[node]+graph[node][j]<distance[j]){
                    distance[j]=distance[node]+graph[node][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println("Node : "+i+" : "+distance[i]);
        }
    }

    int find_min_distance_node(int[] distance, boolean[]visited_nodes){
        int min = Integer.MAX_VALUE;
        int min_distance_node = -1;
        for(int i=0;i<distance.length;i++){
            if(!visited_nodes[i] && distance[i]<min){
                min = distance[i];
                min_distance_node=i;
            }
        }
        return min_distance_node;
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 4, 1, 0},{0,0,2,5},{0,1,0,8},{0,0,0,0}};
        Dijkstra obj = new Dijkstra();
        obj.dijkstra(graph,0);
    }
}
