/** RoundRobinSchedulingAlgorithm.java
 * 
 * A scheduling algorithm that randomly picks the next job to go.
 *
 * @author: Kyle Benson
 * Winter 2013
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

public class RoundRobinSchedulingAlgorithm extends BaseSchedulingAlgorithm {

    /** the time slice each process gets */
    private int quantum;
    Vector<Process> jobs;
    
    private int quanCounter;
    private long turnCounter;
    private int activeIndex;
    private boolean priority;
    
    RoundRobinSchedulingAlgorithm() {
        // Fill in this method
        /*------------------------------------------------------------*/
        activeJob = null;
        quantum = 10;
        turnCounter = 0;
        quanCounter = quantum;
        activeIndex = -1;
        priority = false;
        jobs = new Vector<Process>();

        /*------------------------------------------------------------*/
    }

    /** Add the new job to the correct queue. */
    public void addJob(Process p) {
        
        // Fill in this method
        /*------------------------------------------------------------*/

        jobs.add(p);

        /*------------------------------------------------------------*/
    }

    /** Returns true if the job was present and was removed. */
    public boolean removeJob(Process p) {
        // Fill in this method
        /*------------------------------------------------------------*/

        int jobIndex = jobs.indexOf(p);
        boolean temp = jobs.remove(p);
        if (activeIndex >= jobIndex && jobIndex >= 0)
			--activeIndex;
			try {
				activeJob = jobs.get(activeIndex);
			} catch (ArrayIndexOutOfBoundsException e) {
				activeJob = null;
			}
		quanCounter = 0;
		return temp;

        /*------------------------------------------------------------*/
    }

    /** Transfer all the jobs in the queue of a SchedulingAlgorithm to another, such as
    when switching to another algorithm in the GUI */
    public void transferJobsTo(SchedulingAlgorithm otherAlg) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get the value of quantum.
     * 
     * @return Value of quantum.
     */
    public int getQuantum() {
        return quantum;
    }

    /**
     * Set the value of quantum.
     * 
     * @param v
     *            Value to assign to quantum.
     */
    public void setQuantum(int v) {
        this.quantum = v;
    }

    /**
     * Returns the next process that should be run by the CPU, null if none
     * available.
     */
    public Process getNextJob(long currentTime) {
        // Fill in this method
        /*------------------------------------------------------------*/

        Process p = null, nextJob = null;
        	int index = 0;
        
        	--quanCounter;
        

        	if (activeIndex >= 0 && !isJobFinished() && quanCounter > 0) {
        	    return activeJob;
        	}
        

        	if (jobs.size() == 0){
        	    activeIndex = -1;
        	    return null;
        	}
        
          index = (activeIndex >= (jobs.size() - 1) || activeIndex < 0) ? 0 : activeIndex+1;
        	//if (activeIndex >= (jobs.size() - 1) || activeIndex < 0)
        	//    index = 0;
        	//else
        	//    index = (activeIndex + 1);
        
        	nextJob = (Process) jobs.get(index);
        	activeIndex = index;
        
        	quanCounter = quantum;
        
        	this.activeJob = nextJob;
        	return nextJob;

        /*------------------------------------------------------------*/
    }

    public String getName() {
        return "Round Robin";
    }
    
}