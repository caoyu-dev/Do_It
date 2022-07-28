package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.println("N: " + N + ", M: " + M);
        visited = new boolean[N][M];
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
                System.out.println("arr[" + i + "][" + j + "]: " + arr[i][j]);
            }
        }
        BFS(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {    // 좌표의 유효성 검증
                    if (arr[x][y] != 0 && !visited[x][y]) {  // 갈 수 있는 칸 && 방문 검증
                        visited[x][y] = true;
                        arr[x][y] = arr[now[0]][now[1]] + 1; // depths 업데이트
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
