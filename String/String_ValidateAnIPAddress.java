public class String_ValidateAnIPAddress {
  public boolean isValid(String str) {

    String[] blocks = str.split("\\.", 0);
    if (blocks.length > 4)
      return false;

    for (String block : blocks) {

      if (block.length() > 3 || block.length() <= 0)
        return false;

      int num = Integer.parseInt(block);
      if (num > 255 || (num > 0 && block.charAt(0) == '0'))
        return false;

    }

    return true;
  }

}
