/** PrioritySchedulingAlgorithm.java
 * 
 * A single-queue priority scheduling algorithm.
 *
 * @author: Charles Zhu
 * Spring 2016
 *
 */
package com.jimweller.cpuscheduler;

import java.util.*;

import com.jimweller.cpuscheduler.Process;

public class PrioritySchedulingAlgorithm extends SJFSchedulingAlgorithm {
    @Override
    /** Returns the next process that should be run by the CPU, null if none available.*/
    public Process getNextJob(long currentTime){
        
        // Fill in this method
        /*------------------------------------------------------------*/

    Process p = null, returnJob = (Process) jobs.get(0);
		long priority = 0, highestPriority = returnJob.getPriorityWeight();
		
		if (!isJobFinished() && !isPreemptive())
			return activeJob;
		
		for (int i = 0; i < jobs.size(); ++i) {
			p = (Process) jobs.get(i);
			priority = p.getPriorityWeight();
			if (priority < highestPriority) {
				highestPriority = priority;
				returnJob = p;
			}
		}
		activeJob = returnJob;
		return activeJob;

        /*------------------------------------------------------------*/
    }

    @Override
    public String getName(){
        return "Single-Queue Priority";
    }
}