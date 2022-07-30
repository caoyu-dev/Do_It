package Do_It;

import java.util.*;

/**
 * 5
 * 1 3 2 -1
 * 2 4 4 -1
 * 3 1 2 4 3 -1
 * 4 2 4 3 3 5 6 -1
 * 5 4 6 -1
 */
public class P1167 {
    // 핵심적인 내용
    static ArrayList<Edge>[] arr;
    // 방문 기록 저장 배열
    static boolean[] visited;
    // 거리 저장 배열
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<Edge>();
        }
        // arr 리스트 데이터 저장하기
        for (int i = 0; i < N; i++) {
            // 첫 번째 노드
            int S = sc.nextInt();
            while (true) {
                // 두 번째 노드
                int E = sc.nextInt();
                // 1 `3` 2 `-1` 종료 선언
                if (E == -1) {
                    break;
                }
                // 노드 간의 거리인 에지의 값
                int V = sc.nextInt();
                // 연결
                arr[S].add(new Edge(E, V));
            }
        }
        // 배열 초기화
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        // 1 부터 BFS 시작
        BFS(1);
        int max = 1;
        // 배열에서 가장 큰 값을 가지고 있는 노드를 시작점으로 지정
        for (int i = 2; i < N + 1; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }
        // 배열 초기화
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        // 위에서 찾는 값을 시작점으로 지정
        BFS(max);
        // 오름차순 정렬
        Arrays.sort(distance);
        // 가장 마지막 값 추출
        System.out.println(distance[N]);
    }

    private static void BFS(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        // 큐 자료구조에서 시작 노드 삽입(add 연산)
        queue.add(idx);
        // visited 배열에 현재 노드 방문 저장
        visited[idx] = true;
        // 큐가 빌 때까지 진행
        while (!queue.isEmpty()) {
            // 큐에서 노드 데이터 가져오기(poll 연산)
            int now = queue.poll();
            // 가져온 노드 출력
            for (Edge i : arr[now]) {
                int e = i.e;
                int v = i.value;
                // 현재 노드의 연결 노드 중 방문하지 않은 노드로
                if (!visited[e]) {
                    // 큐에 데이터 삽입(add 연산), visited 배열에 방문 기록 저장
                    visited[e] = true;
                    queue.add(e);
                    // 현재 노드의 거리 + 에지의 거리 값 => 노드 거리 배열 업데이트
                    distance[e] = distance[now] + v;
                }
            }
        }
    }

    private static class Edge {
        // 두 번째 노드
        int e;
        // 노드 간의 거리인 에지의 값
        int value;
        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
