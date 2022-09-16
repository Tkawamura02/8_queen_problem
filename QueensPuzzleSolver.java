import java.util.ArrayList;

public class QueensPuzzleSolver {
	static int snum = 0;
	public static void main(String[] args) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		ArrayList<Integer> univ = new ArrayList<Integer>();
		for (int i = 1; i <= 8; i++)
		univ.add(i);
		System.out.println("Eight-Queens Puzzle: Tiffany Kawamura\n");
		PuzzleSolve.<Integer>solve(8, seq, univ, new QueensTest<Integer>());
			}
	private static class QueensTest<E> implements PuzzleTest<Integer> {
	double q1X=1;
	double q1Y=1;
	double q2X=1;
	double q2Y=1;
	double slope = 0;
	
		public boolean test(ArrayList<Integer> candidate) {
		// How do you decide whether this is a solution or not?
		// You only need to worry about the diagonals. 
		// Hint: calculate the slope between each pair of queens.
			if(candidate.size()==1) {return true;}
			for (int i=0; i<=7; i++) { //System.out.println(i);
				q1X = i;
				q1Y = (double) candidate.get(i); if(q1Y>candidate.size()) {q1Y=1;}
				for (int j=0; j<=7; j++) { 
					q2X = j;
					q2Y = (double) candidate.get(j); //if(q2Y>candidate.size()) {q2Y=1;}
					if (q1Y==q2Y) {q1X++;} 
					else if (q1X>candidate.size() || q2X>candidate.size()) {break;}
					double top = (q2Y-q1Y); double bottom = (q2X-q1X); 
					slope = top/bottom;
					if (bottom == 0 || top == 0) {break;
					} else if (slope == -1 || slope ==1) {
						return false;
					}
				}
			}
			return true;
		}
		
		public void foundSolution(ArrayList<Integer> solution) {
			ArrayList<String> print = new ArrayList<String>();
			snum++;
            System.out.println("Solution #" + snum);
            //System.out.println(solution); //so I can visually see what the array looks like before making the array look pretty
            for (int i=0; i<=7; i++) {
            	for (int x = 0; x <= 7; x++) {
            		print.add(".");
            	}
				int pos = solution.get(i)-1;
				print.set(pos, "Q");
				String formatted = print.toString()
					.replace(",", "")
					.replace("[", "")
					.replace("]", "");
				System.out.println(formatted);
				print.clear();
            }
		}
	}
}