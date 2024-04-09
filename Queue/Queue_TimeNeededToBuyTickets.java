import java.util.LinkedList;
import java.util.Queue;

public class Queue_TimeNeededToBuyTickets {
  public int timeRequiredToBuy(int[] tickets, int k) {

    Queue<Person> q = new LinkedList<>();
    for (int i = 0; i < tickets.length; i++) {
      q.add(new Person(tickets[i], i));
    }

    int time = 0;
    while (!q.isEmpty()) {
      Person p = q.poll();
      int pos = p.pos;
      int tic = p.ticket;
      time++;

      if (pos == k && tic - 1 == 0)
        break;

      if (tic - 1 != 0) {
        q.add(new Person(tic - 1, pos));
      }
    }

    return time;
  }

  class Person {
    int ticket;
    int pos;

    Person(int t, int p) {
      ticket = t;
      pos = p;
    }
  }

  public int timeRequiredToBuyAlternative(int[] ticketsArray, int position) {
    int numberOfPeople = ticketsArray.length;
    int currentIndex = position;
    int timeTaken = 0;

    while (currentIndex >= 0) {
      timeTaken += Math.min(ticketsArray[position], ticketsArray[currentIndex]);
      --currentIndex;
    }

    currentIndex = position + 1;
    --ticketsArray[position];

    while (currentIndex < numberOfPeople) {
      timeTaken += Math.min(ticketsArray[position], ticketsArray[currentIndex]);
      ++currentIndex;
    }

    return timeTaken;
  }
}
