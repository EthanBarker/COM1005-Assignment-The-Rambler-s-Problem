import java.util.*;

public class RamblersState extends SearchState{


	  // the cordinate
	  private Coords cordinate;

	  // constructor
	  public RamblersState(Coords i, int lc, int rc) {
		cordinate = i;
	    localCost = lc;
	    estRemCost = rc;
	  }
	  // accessor
	  
	  public Coords getCordinate() {
	    return cordinate;
	  }

	  // goalPredicate
	  public boolean goalPredicate(Search searcher) {
		RamblersSearch msearcher = (RamblersSearch) searcher;
	    Coords tar = msearcher.getGoal(); // get target coords
	    return (cordinate.getx() == tar.getx() && cordinate.gety() == tar.gety());
	  }

	  // getSuccessors
	  public ArrayList<SearchState> getSuccessors(Search searcher) {
		RamblersSearch msearcher = (RamblersSearch) searcher;
		TerrainMap map = msearcher.getMap();
	    ArrayList<SearchState> succs = new ArrayList<SearchState>();

	    int y = cordinate.gety(); 
	    int x = cordinate.getx();
	    int y2 = msearcher.getGoal().gety();
	    int x2 = msearcher.getGoal().getx();
	    
	    if (y > 0) {
	    	int y1 = y - 1;
	    	int lc = getLocalCost(y,x,y1,x, searcher);
	    	Coords coords = new Coords(y1,x);
	    	int rc = getEstimatedRemaningCost(y,x,y2,x2, searcher);
	    	succs.add((SearchState) new RamblersState(coords,lc,rc));
	    }
	    if (x > 0) {
	    	int x1 = x - 1;
	    	int lc = getLocalCost(y,x,y,x1, searcher);
	    	Coords coords = new Coords(y,x1);
	    	int rc = getEstimatedRemaningCost(y,x,y2,x2, searcher);
	    	succs.add((SearchState) new RamblersState(coords,lc,rc));
	    }
	    if (y < map.getDepth() -1) {
	    	int y1 = y + 1;
	    	int lc = getLocalCost(y,x,y1,x, searcher);
	    	Coords coords = new Coords(y1,x);
	    	int rc = getEstimatedRemaningCost(y,x,y2,x2, searcher);
	    	succs.add((SearchState) new RamblersState(coords,lc,rc));
	    }
	    if (x < map.getWidth() -1) {
	    	int x1 = x + 1;
	    	int lc = getLocalCost(y,x,y,x1, searcher);
	    	Coords coords = new Coords(y,x1);
	    	int rc = getEstimatedRemaningCost(y,x,y2,x2, searcher);
	    	succs.add((SearchState) new RamblersState(coords,lc,rc));
	    }
	    return succs;
	  }

	  private int getLocalCost(int y, int x, int y1, int x1, Search searcher) {
		  RamblersSearch msearcher = (RamblersSearch) searcher;
		  TerrainMap map = msearcher.getMap();
		  int Height1 = map.getTmap()[x1][y1];
		  int Height2 = map.getTmap()[x][y];
		  if (Height2 <= Height1) {
			  localCost = 1;
		  }else {
			  int total =Math.abs(Height2- Height1);
			  localCost = 1 + total;
		  }	  
		  return localCost;
				  
	}
	  
	  private int getEstimatedRemaningCost(int y, int x, int y2, int x2, Search searcher) {
		  RamblersSearch msearcher = (RamblersSearch) searcher;
		  TerrainMap map = msearcher.getMap();
		  int Height1 = map.getTmap()[x2][y2];
		  int Height2 = map.getTmap()[x][y];
		  if (Height2 <= Height1) {
			  estRemCost = 1;
		  }else {
			  int total =Math.abs(Height2- Height1);
			  estRemCost = 1 + total;
		  }	  
		  return estRemCost;
				  
	}

	  public boolean sameState(SearchState s2) {
		  RamblersState ms2 = (RamblersState) s2;
		  Coords ms2C = ms2.getCordinate();
		  return (cordinate.getx() == ms2C.getx() && cordinate.gety() == ms2C.gety());
	  }

	  // toString
	  public String toString() {
	    return ("cordinate State: " + "(x:" + cordinate.getx() + " y:" + cordinate.gety() +")");
	  }

	}
