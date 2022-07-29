package Do_It;

import java.io.IOException;
import java.util.*;

/**
 * 백준 1206번 문제라고 표기되어 있는데, 이 문제가 아니었다.
 * 계속 Runtime 에러가 발생하여 하루를 고민했는데 시간이 아쉽다.
 * 그러나 덕분에 여러 방향으로 풀어보았다. 의미를 찾는 시간..
 *
 * 26(빈출) DFS 와 BFS 프로그램
 * 그래프를 DFS 로 탐색한 결과와 BFS 로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 노드가 여러 개일 경우에는 노드 번호가 작은 것을 먼저 방문하고
 * 더 이상 방문할 수 있는 노드가 없을 때 종료한다. 노드 번호는 1 에서 N 까지다.
 *
 * 입력)
 * 1 번째 줄에 노드의 개수 N(1<=N<=1,000), 에지의 개수 M(1<=M<=10,000), 탐색을 시작할 노드의 번호 V 가 주어진다.
 * 그다음 M 개의 줄에는 에지가 연결하는 두 노드의 번호가 주어진다. 어떤 두 노드 사이에 여러 개의 에지가 있을 수 있다.
 * 입력으로 주어지는 에지는 양방향이다.
 *
 * 출력)
 * 1 번째 줄에 DFS 를 수행한 결과, 그다음 줄에 BFS 를 수행한 결과를 출력한다.
 * V 부터 방문된 점을 순서대로 출력하면 된다.
 *
 * 예제 입력 1)
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 *
 * 예제 출력 1)
 * 1 2 4 3
 * 1 2 3 4
 *
 * 예제 입력 2)
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 *
 * 예제 출력 2)
 * 3 1 2 5 4
 * 3 1 4 2 5
 */
public class P1206_pre {
    static int[][] map;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int start = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            int idx1 = sc.nextInt();
            int idx2 = sc.nextInt();
            map[idx1 - 1][idx2 - 1] = 1;
            map[idx2 - 1][idx1 - 1] = 1;
        }

        DFS(start - 1);
        System.out.println();
        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }
        BFS(start - 1);
    }

    private static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + 1 + " ");
        for (int i = 0; i < N; i++) {
            if (map[start][i] == 1 && visited[i] == false) {
                DFS(i);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + 1 + " ");
            for (int i = 0; i < N; i++) {
                if (map[start][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
