public class HashMap_DividePlayersIntoTeamsOfEqualSkill {
  public long dividePlayers(int[] skill) {

    int n = skill.length;
    int totalSkills = 0;
    int freq[] = new int[1001];

    for (int s : skill) {
      totalSkills += s;
      freq[s]++;
    }

    if (totalSkills % (n >> 1) != 0)
      return -1;

    int target = totalSkills / (n >> 1);
    long totalChem = 0;

    for (int playerSkill : skill) {
      int partnerSkill = target - playerSkill;

      if (freq[partnerSkill] == 0)
        return -1;

      totalChem += (long) playerSkill * (long) partnerSkill;
      freq[partnerSkill]--;
    }

    return totalChem >> 1;
  }
}
