package concurrent_assignment2.A2;

import concurrent_assignment2.A_intro.Queue;

/**
 * Use the synchronized keyword and signals so that you do not need to busy
 * wait. But of course you still need your variable to know whose's turn it is.
 *
 */
class Signalled_Queue implements Queue {

    int n = 0;
    boolean readerturn = false;

    @Override
    synchronized public void read() {
        if (!readerturn) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        System.out.println(n + " reader");
        readerturn = false;
        notify();
    }

    @Override
    synchronized public void read(int ID) {

    }

    @Override
    synchronized public void write(int x) {
        if (readerturn) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        n = x;
        System.out.println(n + " writer");
        readerturn = true;
        notify();
    }

}
