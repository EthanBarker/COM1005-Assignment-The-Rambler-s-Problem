import java.util.*;

public class RunRamblersBB {
	
	  public static void main(String[] arg) {

		    TerrainMap tm = new TerrainMap("tmc.pgm");


		    RamblersSearch searcher = new RamblersSearch(tm , new Coords (1,2));
		    RamblersState initState = (RamblersState) new RamblersState(new Coords(8,8),0,0);

		    String res_bb = searcher.runSearch(initState, "A*");
		    System.out.println(res_bb);
		  }
		}
