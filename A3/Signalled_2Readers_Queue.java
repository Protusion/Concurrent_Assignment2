package concurrent_assignment2.A3;

import concurrent_assignment2.A_intro.Queue;

/**
 * Use the synchronized keyword and signals.
 *
 * You cannot decide whose's turn it is based on a 2 states variables, so know
 * use a variable which allows for more values (you need 3 states, that is, 3
 * turns).
 *
 */
class Signalled_2Readers_Queue implements Queue {

    int n = 0;
    int turn = 0;

    @Override
    synchronized public void read() {

    }

    @Override
    synchronized public void read(int ID) {
        while (turn != ID) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

        System.out.println(n + " Reader");
        turn++;
        notifyAll();

    }

    @Override
    synchronized public void write(int x) {
        while (turn != 2) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        n = x;
        System.out.println(n);
        turn = 0;
        notifyAll();
    }

}
