import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int seatNum = Integer.parseInt(br.readLine());
        String seatInfo = br.readLine();
        String newSeat = "";
        int holderCnt = 0;

        for (int i = 0; i < seatNum; i++) {
            if(seatInfo.charAt(i) == 'S'){
                newSeat += "*S";
            } else {
                newSeat += "*LL";
                i++;
            }
        }
        newSeat += "*";

        for(int i = 0; i < newSeat.length(); i++) {
            if(newSeat.charAt(i) == '*')
                holderCnt++;
        }
        holderCnt = Math.min(holderCnt, seatNum);
        bw.write(holderCnt + "");
        bw.flush();
        bw.close();
    }
}
