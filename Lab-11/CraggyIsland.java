import java.util.*;

/**
 * Craggy Island is an island with two inhabitants who interact.
 * One prepares tea for the other.
 *
 * @author Colm Cahalane (ID: 113326986)
 */
public class CraggyIsland{
	private static Boolean isTeaReady;
	private static Boolean teaAskedFor;

	/**
	 * constructor for a craggy island where
	 * the tea is cold and lifeless, and
	 * nobody wants it anyway
	 * @return a reference to a CraggyIsland.
	 */
	public CraggyIsland(){
		isTeaReady = false;
		teaAskedFor = false;
	}

	/**
	 * A test case for two Thread objects that share resources
	 * and depend on each other in a producer/consumer relationship.
	 * A consumer must wait for a producer in a wait/notify system.
	 * @param args Command line arguments, here unused.
	 */
	public static void main(String[] args) {
		final CraggyIsland craggyIsland = new CraggyIsland();

		// Ted requires Tea to be produced.
		// He also says Mass and sits down before he
		// looks for Tea.
		Thread ted = new Thread(){
			private CraggyIsland island = craggyIsland;

			public void sayMass(){
				System.out.println("Saying Mass");
			}
			public void sitDown(){
				System.out.println("Sitting down");
			}
			public void haveTea(){
				// If Tea isn't ready, ask for it
				if(!island.isTeaReady){
					askForTea();
				}
				System.out.println("Having tea");
				// Once tea is consumed reset this flag.
				island.isTeaReady = false;
			}
			public void askForTea(){
				island.teaAskedFor = true;
				synchronized(island){
					// Let other processes in the island start working.
					island.notify();
					while(!island.isTeaReady){
						try{
							// If tea isn't ready, wait until it is.
							island.wait();
						} catch (Exception e){}
					}
				}
			}

			@Override
			public void run(){
				sayMass();
				sitDown();
				haveTea();
			}
		};

		// Mrs. Doyle produces Tea for Ted, but only when he asks for it 
		// directly. Otherwise, she will wait.
		Thread mrsDoyle = new Thread(){
			private CraggyIsland island = craggyIsland;

			public void serveTea(){
				synchronized(island){
					while(!island.teaAskedFor){
						try{
							// If nobody wants tea, wait until they do.
							island.wait();
						} catch (Exception e){}
					}
					// Set up the flag that tea is ready.
					island.isTeaReady = true;
					// No more tea is needed, reset flag.
					island.teaAskedFor = false;
					System.out.println("Serving tea");

					// Allow other processes to continue if waiting.
					island.notify();
				}
			}
			
			@Override
			public void run(){
				serveTea();
			}
		};

		mrsDoyle.start();
		ted.start();
	}
}