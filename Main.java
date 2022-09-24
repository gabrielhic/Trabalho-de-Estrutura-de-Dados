import java.util.Scanner;
public class Main {
  static float validaPos(String exp) {
    Pilha stack = new Pilha(8);
    char c = ' ';
    for (int i = 0; i < exp.length(); i++) {
      c = exp.charAt(i);
      if (c == ' ')
        continue;
      else if (Character.isDigit(c)) {
        float n = 0;
        int frac = 0;
        int contador = 0;
        while (Character.isDigit(c)) {
          n = n * 10 + (int) (c - '0');
          i++;
          c = exp.charAt(i);
        }
        if (c == '.') {
          i++;
          c = exp.charAt(i);
          while (Character.isDigit(c)) {
            frac = frac % 10 + (int) (c - '0');
            i++;
            contador--;
            c = exp.charAt(i);
          }
        }
        i--;
        stack.push(n + (float) (frac * Math.pow(10, contador)));
      } else {
        float ope1 = stack.pop();
        float ope2 = stack.pop();

        switch (c) {
          case '+':
            stack.push(ope2 + ope1);
            break;

          case '-':
            stack.push(ope2 - ope1);
            break;

          case '/':
            stack.push(ope2 / ope1);
            break;

          case '*':
            stack.push(ope2 * ope1);
            break;
        }
      }
    }
    if (Character.isDigit(c)) {
      System.out.println("EXPRESSÃO ERRADA NÚMERO EXTRA");
      System.exit(-1);
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String exp = sc.nextLine();
    System.out.println("Validação pós-fixa " + String.format("%.2f", validaPos(exp)));
  }
}
