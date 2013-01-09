package rpg;

import javax.swing.SwingUtilities;

public class Screen2Lib {
	// Called from non-UI thread
	public static void animateDis() {
	  for (int i = 1; i <= 100; i++) {
	    updateProgress1(i);
	    try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	}

	private static void updateProgress1(final int i) {
	  SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
	      // Here, we can safely update the GUI
	      // because we'll be called from the
	      // event dispatch thread
	      Screen2.pkmn2_hpbar.setValue(i);
	    }
	  });
	}
}
