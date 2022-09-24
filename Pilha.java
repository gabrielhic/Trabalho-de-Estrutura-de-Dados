class Pilha {
  private float vetor[];
  private int topo;
  private int capacidade;

  Pilha(int tamanho) {
    vetor = new float[tamanho];
    capacidade = tamanho;
    topo = -1;
  }

  public void push(float x) {
    if (isFull()) {
      System.out.println("Pilha full!! PROGRAMA ENCERRADO\n");
      System.exit(-1);
    }
    System.out.println("Inserindo " + x);
    vetor[++topo] = x;
  }

  public float pop() {
    if (isEmpty()) {
      System.out.println("Expressão Inválida\nOperador Extra!!!");
      System.exit(-1);
    }
    System.out.println("Removendo " + peek());
    return vetor[topo--];
  }

  public float peek() {
    if (!isEmpty()) {
      return vetor[topo];
    } else {
      System.exit(-1);
    }

    return -1;
  }

  public int size() {
    return topo + 1;
  }

  public boolean isEmpty() {
    return topo == -1;
  }

  public boolean isFull() {
    return topo == capacidade - 1;
  }
}