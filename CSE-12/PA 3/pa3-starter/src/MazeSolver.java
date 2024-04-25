/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		wl.add(maze.start);
		maze.start.visit();

		while(!wl.isEmpty()){
			Square current = wl.remove();
			Square neighbor;
			current.visit();
			int c = current.getCol();
			int r = current.getRow();

			if(current == maze.finish){
				return current;
			}
			else{
				//North
				//check bounds, don't get out
				if(r - 1 >= 0){
					//check if the walls or visited
					neighbor = maze.contents[r-1][c];
					if(!(neighbor.isVisited() || neighbor.getIsWall())){
						neighbor.visit();
						neighbor.setPrevious(current);
						wl.add(neighbor);
					}
				}
				//South
				if(r + 1 < maze.rows){
					//check if the walls or visited
					neighbor = maze.contents[r+1][c];
					if(!(neighbor.isVisited() || neighbor.getIsWall())){
						neighbor.visit();
						neighbor.setPrevious(current);
						wl.add(neighbor);
					}
				}
				//East
				if(c + 1 < maze.cols){
					//check if the walls or visited
					neighbor = maze.contents[r][c+1];
					if(!(neighbor.isVisited() || neighbor.getIsWall())){
						neighbor.visit();
						neighbor.setPrevious(current);
						wl.add(neighbor);
					}
				}
				//West
				if(c - 1 >= 0){
					//check if the walls or visited
					neighbor = maze.contents[r][c-1];
					if(!(neighbor.isVisited() || neighbor.getIsWall())){
						neighbor.visit();
						neighbor.setPrevious(current);
						wl.add(neighbor);
					}
				}
			}
		}

		return null;
	}

	/* Add any helper methods you want */
}
