package schedulingProcess;

import java.util.*;

public class schedule {
    private static final int time_slice = 1;

    private static class Job {
        int id;
        int priority;
        int duration;
        int remaining_time;

        public Job(int id, int priority, int duration) {
            this.id = id;
            this.priority = priority;
            this.duration = duration;
            this.remaining_time = duration;
        }
    }

    public static void main(String[] args) {
        // Prompt user for input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter job information (in the format 'Job priority duration'): ");
        String job_information = scanner.nextLine();
        System.out.print("Enter abbreviation of the chosen scheduling policy (FCFS(First come first served), HP(Highest Priority), or SRTF(Shortest remaining time first)): ");
        String policy = scanner.nextLine();

        String[] input = job_information.split(" ");
        int priority = Integer.parseInt(input[1]);
        int duration = Integer.parseInt(input[2]);

        Job job = new Job(1, priority, duration);

        List<Job> jobs = new ArrayList<>();
        jobs.add(job);
        Collections.sort(jobs, (j1, j2) -> j2.priority - j1.priority);
        
        int current_time = 0;
        while (!jobs.isEmpty()) {
            Job chosen_job = null;
            switch (policy) {
                case "FCFS":
                    chosen_job = jobs.get(0);
                    break;
                case "HP":
                    chosen_job = jobs.get(0);
                    break;
                case "SRTF":
                    chosen_job = jobs.stream()
                            .filter(j -> j.remaining_time > 0)
                            .min(Comparator.comparingInt(j -> j.remaining_time))
                            .orElse(null);
                    break;
            }

            if (chosen_job != null) {
                System.out.println("System time [" + current_time + "] - job " + chosen_job.id + " is running.");
                chosen_job.remaining_time -= time_slice;
                if (chosen_job.remaining_time <= 0) {
                    jobs.remove(chosen_job);
                }
            } else {
                System.out.println("System time [" + current_time + "] - no job is running.");
            }

            current_time += time_slice;
        }

        scanner.close();
    }
}