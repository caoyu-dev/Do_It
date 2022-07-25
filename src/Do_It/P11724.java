package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {
    public static ArrayList<Integer>[] arr;
    public static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 간선 정보
        arr = new ArrayList[N + 1];
        // 방문 정보
        visited = new boolean[N + 1];
        int idx1, idx2, ans = 0;

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            idx1 = Integer.parseInt(st.nextToken());
            idx2 = Integer.parseInt(st.nextToken());
            arr[idx1].add(idx2);
            arr[idx2].add(idx1);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int value) {
        if (visited[value]) {
            return;
        }
        visited[value] = true;
        for (int idx : arr[value]) {
            if (!visited[idx]) {
                dfs(idx);
            }
        }
    }
}
