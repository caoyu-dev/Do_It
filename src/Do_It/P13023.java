package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023 {
    public static ArrayList<Integer>[] arr;
    public static int N, M, ans;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            arr[idx1].add(idx2);
            arr[idx2].add(idx1);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (ans > 0) {
                break;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int start, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }
        visited[start] = true;
        for (int idx : arr[start]) {
            if (!visited[idx]) {
                dfs(idx, depth + 1);
            }
        }
        visited[start] = false;
    }
}
