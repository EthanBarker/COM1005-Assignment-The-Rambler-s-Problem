import java.util.*;

public class RunRamblersBB {
	
	  public static void main(String[] arg) {

		    TerrainMap tm = new TerrainMap("tmc.pgm");


		    RamblersSearch searcher = new RamblersSearch(tm , new Coords (3,6));
		    RamblersState initState = (RamblersState) new RamblersState(new Coords(15,5),0);

		    String res_bb = searcher.runSearch(initState, "branchAndBound");
		    System.out.println(res_bb);
		  }
		}
