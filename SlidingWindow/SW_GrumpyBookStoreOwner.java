public class SW_GrumpyBookStoreOwner {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

    int n = customers.length;
    int unSatisfiedCust = 0;

    // initial window
    for (int i = 0; i < minutes; i++) {
      unSatisfiedCust += customers[i] * grumpy[i];
    }

    int maxUnSatisfiedCust = unSatisfiedCust;

    for (int i = minutes; i < n; i++) {

      unSatisfiedCust += customers[i] * grumpy[i];
      unSatisfiedCust -= customers[i - minutes] * grumpy[i - minutes];

      maxUnSatisfiedCust = Math.max(maxUnSatisfiedCust, unSatisfiedCust);
    }

    // adding the satisfied customers during non-grumpy minutes
    int totalCustomers = maxUnSatisfiedCust;
    for (int i = 0; i < n; i++) {
      totalCustomers += customers[i] * (1 - grumpy[i]);
    }

    return totalCustomers;
  }
}
