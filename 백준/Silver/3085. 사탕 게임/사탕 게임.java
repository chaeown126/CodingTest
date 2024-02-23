import java.io.*;

public class Main {
    static int max = 0;
    static char bomboni[][];
    static boolean isComplete = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        bomboni = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                bomboni[i][j] = str.charAt(j);
            }
        }

        checkCurrentCandy(bomboni);

        if(!isComplete) {
            candyChange(true, bomboni); // 행
            candyChange(false, bomboni); // 열
        }

        sb.append(max);
        System.out.print(sb);
    }

    private static void checkCurrentCandy(char bomboni[][]) {
        for(int i = 0; i < bomboni.length; i++) {
            for(int j = 0; j < bomboni.length; j++) {
                getMaxCount(bomboni);
            }
        }
    }

    private static void candyChange(boolean direction, char bomboni[][]) {
        if(!isComplete) {
            if(direction) { // 행
                for(int i = 0; i < bomboni.length; i++) {
                    for(int j = 1; j < bomboni.length; j++) {
                        if(bomboni[i][j] != bomboni[i][j-1]) {
                            char tempCandy = bomboni[i][j];
                            bomboni[i][j] = bomboni[i][j-1];
                            bomboni[i][j-1] = tempCandy;

                            getMaxCount(bomboni);

                            bomboni[i][j-1] = bomboni[i][j];
                            bomboni[i][j] = tempCandy;
                        }
                    }
                }
            } else { // 열
                for(int i = 1; i < bomboni.length; i++) {
                    for(int j = 0; j < bomboni.length; j++) {
                        if(bomboni[i][j] != bomboni[i-1][j]) {
                            char tempCandy = bomboni[i][j];
                            bomboni[i][j] = bomboni[i-1][j];
                            bomboni[i-1][j] = tempCandy;

                            getMaxCount(bomboni);

                            bomboni[i-1][j] = bomboni[i][j];
                            bomboni[i][j] = tempCandy;
                        }
                    }
                }
            }
        }
    }

    private static void getMaxCount(char bomboni[][]) {
        for (int i = 0; i < bomboni.length; i++) {
            int count = 1;
            for (int j = 0; j < bomboni.length - 1; j++) {
                if (bomboni[i][j] == bomboni[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

        for (int i = 0; i < bomboni.length; i++) {
            int count = 1;
            for (int j = 0; j < bomboni.length - 1; j++) {
                if (bomboni[j][i] == bomboni[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
    }
}