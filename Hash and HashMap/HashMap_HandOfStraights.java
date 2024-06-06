import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMap_HandOfStraights {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) {
      return false;
    }

    Map<Integer, Integer> freq = new HashMap<>();

    for (int card : hand) {
      freq.put(card, freq.getOrDefault(card, 0) + 1);
    }

    Arrays.sort(hand);

    for (int i = 0; i < hand.length; i++) {
      if (freq.get(hand[i]) == 0) {
        continue;
      }

      for (int j = 0; j < groupSize; j++) {
        int currCard = hand[i] + j;
        if (freq.getOrDefault(currCard, 0) == 0) {
          return false;
        }

        freq.put(currCard, freq.get(currCard) - 1);
      }
    }

    return true;
  }

  public boolean isNStraightHandTreeMap(int[] hand, int groupSize) {

    int n = hand.length;

    if (n % groupSize != 0)
      return false;

    Map<Integer, Integer> cardCount = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      cardCount.put(hand[i], cardCount.getOrDefault(hand[i], 0) + 1);
    }

    while (cardCount.size() > 0) {

      int card = cardCount.entrySet().iterator().next().getKey();

      for (int i = 0; i < groupSize; i++) {
        int nextCard = card + i;

        if (!cardCount.containsKey(nextCard)) {
          return false;
        }

        cardCount.put(nextCard, cardCount.get(nextCard) - 1);

        if (cardCount.get(nextCard) == 0) {
          cardCount.remove(nextCard);
        }
      }

    }

    return true;
  }
}
