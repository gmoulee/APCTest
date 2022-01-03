import java.io.*;
import java.util.*;

class Lego{
	public static int getProfit(int size) {
		if(size == 1) return -1;
		else if(size == 2) return 3;
		else if(size == 3) return 1;
		else return 0;
	}
	public static int calculateProfit(String[] tcase) {
		int profit = 0;
		int totalTrunks = Integer.parseInt(tcase[0]);
		int[] trunks = new int[tcase.length];
		for(int i=0;i<trunks.length;i++) {
			trunks[i] = Integer.parseInt(tcase[i]);
		}
		int size = 0;
		for(int i=1;i<trunks.length;i++) {
			if((trunks[i]+size) >= 3) {
				int first = 3 - size;
				profit += getProfit(first);
				int second = trunks[i]-first;
				profit += getProfit(second);
				size = second;
			}
			else {
				size += trunks[i];
				profit += getProfit(trunks[i]);
			}
		}
		return profit;
	}
	public static void main(String[]  args) throws IOException {
		 BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		List<String> input = new ArrayList<String>();
		int tcases = Integer.parseInt(bi.readLine());
		int tc = 1;
		if( tcases != 0) {
			int result = 0;
			for(int i=0;i<tcases;i++) {
				String tcase = bi.readLine();
				String[] temp = tcase.split(" ");
				result += calculateProfit(temp);
			}
			System.out.println("Max Profit :"+result);
		}
		
	}
}