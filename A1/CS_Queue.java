package concurrent_assignment2.A1;

import concurrent_assignment2.A_intro.Queue;

/**
 * Use condition synchronization by means of busy wait.
 *
 * What kind of variable do you need to implement busy wait synchronization?
 *
 * Set a meaningful name for such variable.
 *
 */
class CS_Queue implements Queue {

    int n = 0;
    boolean readerturn;

    @Override
    public void read() {
        while (!readerturn) {
        }
        System.out.println(n + " reader");
        readerturn = false;
    }

    @Override
    public void read(int ID) {
        //never used
    }

    @Override
    public void write(int x) {
        while (readerturn) {
        }
        n = x;
        System.out.println(n + " writer");
        readerturn = true;
    }
}
