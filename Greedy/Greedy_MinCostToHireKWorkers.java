import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy_MinCostToHireKWorkers {
  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

    int n = quality.length;

    // adding all worker's wage to qualtiy ratio and their quality
    List<Worker> workers = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      workers.add(new Worker(wage[i] / (double) quality[i], quality[i]));
    }

    // sorting according to wage to quality ratio
    Collections.sort(workers);

    // max heap to maintain quality of workers
    PriorityQueue<Integer> highQualityWorkers = new PriorityQueue<>(Collections.reverseOrder());

    int qualitySum = 0;
    double minCost = Double.MAX_VALUE;

    for (Worker worker : workers) {

      qualitySum += worker.quality;

      highQualityWorkers.offer(worker.quality);

      if (highQualityWorkers.size() > k) {
        qualitySum -= highQualityWorkers.poll();
      }

      if (highQualityWorkers.size() == k) {
        minCost = Math.min(minCost, qualitySum * worker.ratio);
      }
    }

    return minCost;
  }

  class Worker implements Comparable<Worker> {
    double ratio;
    int quality;

    Worker(double ratio, int quality) {
      this.ratio = ratio;
      this.quality = quality;
    }

    @Override
    public int compareTo(Worker other) {
      return Double.compare(this.ratio, other.ratio);
    }

  }
}
