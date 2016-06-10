# CPU-Scheduler

A project in the course CS143 Principles of Operating Systems at University of California, Irvine Spring 2016.

Implementing various CPU scheduling algorithms:

####1. First-Come First-Served (FCFS)
A simple FCFS algorithm. If there is a tie, use PID as the tie-breaker (smaller-PID first).

####2. Shortest Job First (SJF)
This algorithm should run the job with the shortest remaining time first. If there is a tie, use
PID as the tie-breaker (smaller-PID first).
It should implement the OptionallyPreemptiveSchedulingAlgorithm interface and preempt
the currently running processes only if it is set to be preemptive.

####3. Single-Queue Priority (Priority)
This algorithm should run the job with the highest priority (lowest priority number). If there
is a tie, use PID as the tie-breaker (smaller-PID first).

####4. Round Robin (RR)
Default time quantum is 10.


###How To Run
```bash
cd CPUSchedulingSimulatorNoGUI/

./simu.sh samples/sample_1.jobs.txt Random
./simu.sh samples/sample_2.jobs.txt FCFS
./simu.sh samples/sample_4.jobs.txt SJF
./simu.sh samples/sample_4.jobs.txt SJF true
./simu.sh samples/sample_3.jobs.txt Priority
./simu.sh samples/sample_3.jobs.txt Priority true
./simu.sh samples/sample_5.jobs.txt RR
```
