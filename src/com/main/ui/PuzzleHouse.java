package com.main.ui;

public class PuzzleHouse {

	//回溯法来走迷宫
	private int[][] maze = {{2,2,2,2,2,2,2,2,2},
										{2,0,0,0,0,0,0,0,2},
										{2,0,2,2,0,2,2,0,2},
										{2,0,2,0,0,2,0,0,2},
										{2,0,2,0,2,0,2,0,2},
										{2,0,0,0,0,0,2,0,2},
										{2,2,0,2,2,0,2,2,2},
										{2,0,0,0,0,0,0,0,2},
										{2,2,2,2,2,2,2,2,2}};
	
	private int startPosI =1;  //入口的i 坐标
	private int startPosJ =1;
	private int endPosI =7;  //终点的坐标
	private int endPosJ =7;
	
	public void visited(int i,int j) {
		maze[i][j]=1; //1很关键，为了不走回头的路
		if(i==endPosI && j == endPosJ) { //找到了出口
			System.out.println("找到一条出路");
			for(int m=0;m<maze.length;m++) {
				for(int n=0;n<maze.length;n++) {
					if(maze[m][n]==2) System.out.print("2");
					else if(maze[m][n]==1) System.out.print("$");
					else System.out.print("0");
				}
				System.out.println();
			}
		}
		//注意，这里打印了也没有停止return，还是继续搜索的，就是为了回退到上一个节点处，地图周围都是墙也是关键
		//向左边寻找通路
		if(maze[i][j-1]==0) {
			visited(i,j-1);
		}
		if(maze[i][j+1]==0) {
			visited(i,j+1);
		}
		if(maze[i-1][j]==0) {
			visited(i-1,j);
		}
		if(maze[i+1][j]==0) {
			visited(i+1,j);
		}
		maze[i][j]=0;
	}
	
	public static void main(String[] args) {
		PuzzleHouse p =new PuzzleHouse();
		p.visited(1, 1);
	}

}
