/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alejandro E. Garces
 */

public class  ThSultanSuccessors{

	static boolean[][] occuped = new boolean[8][8];
	static int[][] board = new int[8][8];
	static int answer;
	static boolean[] occupedRow = new boolean[8];
	
	static boolean canLeft(int x, int y)
	{
		int min = Math.min(x, y);
		int i = x-min;
		int j = y-min;
		for(;i<8 && j<8;)
			if(occuped[i++][j++])return false;

		return true;
	}
	
	static boolean canRight(int x, int y)
	{
		int min = Math.min(x, 7-y);
		int i = x-min;
		int j = y+min;
		for(;i<8 && j>=0;)
			if(occuped[i++][j--])return false;
		return true;
	}
	
	static void BT(int col, int acum)
	{
		if(col == 8)
		{
			//System.out.println(answer+" - "+acum);
			answer = Math.max(acum, answer);
			return;
		}
		
		for(int i=0;i<8;i++)
		{
			if(!occupedRow[i] && canLeft(i, col) && canRight(i, col))
			{
				occupedRow[i] = true;
				occuped[i][col] = true;
				BT(col+1, acum+board[i][col]);
				occupedRow[i] = false;
				occuped[i][col] = false;
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		//BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
                Scanner in = new Scanner((System.in));
		//int n = Integer.parseInt(in.readLine());
                int n = in.nextInt();
		//String[] read;
		while(n-->0)
		{
			answer = 0;
			for(int i=0;i<8;i++)
			{
				//read = in.readLine().split("[ ]+");
                                //System.out.println(Arrays.toString(read));
				for(int j=0;j<8;j++)
				//board[i][j] = Integer.parseInt(read[j]);
                                    board[i][j] = in.nextInt();
			}
			BT(0, 0);
			System.out.printf("%5d\n", answer);
		
		}
		
		in.close();
		System.exit(0);
	}
}
	
/*
 9
1 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 1
0 0 0 0 0 1 0 0
0 0 1 0 0 0 0 0
0 0 0 0 0 0 1 0
0 1 0 0 0 0 0 0
0 0 0 1 0 0 0 0
78 53 31 36 98 52 79 36
2 91 87 53 68 18 96 41
44 43 71 48 94 46 17 56
4 35 27 39 61 80 43 9
49 56 95 3 33 16 45 54
82 16 96 12 43 50 83 59
48 79 21 66 29 19 89 72
85 98 81 97 91 14 71 82
3 27 94 76 98 96 68 55
99 26 86 91 24 92 32 66
35 51 60 34 18 77 59 31
11 36 83 59 33 52 40 99
8 55 16 29 74 96 64 56
63 78 85 61 78 23 63 94
69 10 82 45 51 4 72 97
28 19 10 62 25 6 45 88
28 57 60 77 66 83 14 69
63 56 33 38 15 91 56 66
4 31 92 40 56 57 34 33
74 40 58 96 36 62 53 68
2 67 33 85 20 3 52 10
75 67 76 85 73 22 49 6
67 14 1 8 95 63 15 96
64 16 28 3 76 83 77 65
56 45 53 62 12 65 75 78
61 37 70 11 26 9 43 29
83 75 30 78 61 24 39 42
1 81 32 59 87 98 97 89
3 70 44 67 54 59 40 83
65 10 81 74 81 19 94 53
55 60 13 37 84 9 90 24
71 98 90 96 43 9 53 60
38 47 43 2 92 43 59 24
17 61 89 77 82 91 23 91
67 29 87 6 30 65 18 91
47 50 36 95 52 88 41 88
39 97 97 21 12 45 12 96
27 79 75 71 6 35 3 53
93 65 5 65 93 10 22 87
85 34 6 76 62 85 17 78
73 68 61 19 25 67 27 97
94 79 35 51 63 33 71 44
92 80 23 34 10 24 68 59
24 76 49 10 47 19 96 39
89 28 96 45 79 84 4 19
3 97 72 62 2 40 26 66
99 98 11 80 43 75 77 46
85 28 27 17 27 75 57 67
0 0 0 0 0 10 0 0
0 10 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 10 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
12 56 12 98 36 1 4 9
23 98 2 5 47 8 17 94
8 2 3 6 8 4 76 3
46 7 45 43 6 67 23 54
8 65 4 2 46 2 7 46
24 45 67 87 4 2 76 8
3 3 6 8 7 4 3 6
94 2 2 76 67 43 4 42 
 */