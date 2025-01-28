
import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int peopleCount, partyCount;
    public static ArrayList<ArrayList<Node>> map;
    public static boolean[] finalList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        peopleCount = Integer.parseInt(st.nextToken());
        partyCount = Integer.parseInt(st.nextToken());

        finalList = new boolean[partyCount+1];

        map = new ArrayList<>();
        for (int i = 0; i <= peopleCount; i++) {
            map.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        List<Integer> truthKnowPeopleList = new ArrayList<>();
        int truthCount = Integer.parseInt(st.nextToken());
        for(int i = 0; i < truthCount; i++) {
            truthKnowPeopleList.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < partyCount; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            int[] partyPeople = new int[people + 1];
            if (people == 1) {
                int from = Integer.parseInt(st.nextToken());
                map.get(from).add(new Node(i+1, 0));
                continue;
            }

            for (int j = 0; j < people; j++) {
                partyPeople[j+1] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= people; j++) {
                int from = partyPeople[j];
                for (int k = j + 1; k <= people; k++) {
                    int to = partyPeople[k];
                    map.get(from).add(new Node(i+1, to));
                    map.get(to).add(new Node(i+1, from));
                }
            }
        }

        for(int i : truthKnowPeopleList) {
            BFS(i);
        }

        int maxPartyCount = 0;
        for(int i = 1; i <= partyCount; i++) {
            if(!finalList[i]) maxPartyCount++;
        }

        System.out.println(maxPartyCount);
    }

    public static void BFS(int start) {
        boolean[] visited = new boolean[partyCount+1];
        boolean[] peoplevisited = new boolean[peopleCount + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        peoplevisited[start] = true;

        while(!queue.isEmpty()) {
            ArrayList<Node> arr = map.get(queue.poll());
            for(Node node : arr) {
                if (!visited[node.partyNum]) {
                    visited[node.partyNum] = true;
                }
                if(node.target == 0) continue;
                if(!peoplevisited[node.target]) {
                    peoplevisited[node.target] = true;
                    queue.add(node.target);
                }
            }
        }

        for (int i = 1; i <= partyCount; i++) {
            if(visited[i]) finalList[i] = true;
        }

    }

    public static class Node {
        int partyNum;
        int target;

        public Node(int partyNum, int target) {
            this.partyNum = partyNum;
            this.target = target;
        }
    }
}